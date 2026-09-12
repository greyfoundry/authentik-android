package dev.greyfoundry.authentik.auth

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import dev.greyfoundry.authentik.AuthRedirectActivity
import dev.greyfoundry.authentik.domain.model.AuthFailure
import dev.greyfoundry.authentik.domain.model.InstanceId
import dev.greyfoundry.authentik.domain.model.InstanceProfile
import dev.greyfoundry.authentik.domain.model.RemoteRevocation
import dev.greyfoundry.authentik.network.ApiClientFactory
import kotlin.coroutines.resume
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import net.openid.appauth.AuthState
import net.openid.appauth.AuthorizationException
import net.openid.appauth.AuthorizationResponse
import net.openid.appauth.AuthorizationService
import net.openid.appauth.AuthorizationServiceConfiguration
import okhttp3.FormBody
import okhttp3.Request
import okhttp3.HttpUrl.Companion.toHttpUrl

internal class DefaultOidcClient(
    context: Context,
    private val apiClientFactory: ApiClientFactory = ApiClientFactory(),
) : OidcClient {
    private val applicationContext = context.applicationContext

    override suspend fun launchAuthorization(profile: InstanceProfile, instanceId: InstanceId) {
        val configuration = discover(profile)
        val request = try {
            AuthorizationRequestFactory.create(profile, configuration)
        } catch (error: IllegalArgumentException) {
            throw OidcClientException(AuthFailure.INVALID_CONFIGURATION, error)
        }
        val completion = callbackPendingIntent(instanceId, cancelled = false)
        val cancellation = callbackPendingIntent(instanceId, cancelled = true)
        val service = AuthorizationService(applicationContext)
        try {
            service.performAuthorizationRequest(request, completion, cancellation)
        } catch (error: Exception) {
            throw OidcClientException(AuthFailure.AUTHORIZATION_FAILED, error)
        } finally {
            service.dispose()
        }
    }

    override suspend fun exchangeAuthorizationResponse(
        profile: InstanceProfile,
        responseIntent: Intent,
    ): PersistedOidcSession {
        if (responseIntent.getBooleanExtra(AuthRedirectActivity.EXTRA_CANCELLED, false)) {
            throw OidcClientException(AuthFailure.AUTHORIZATION_CANCELLED)
        }
        val response = AuthorizationResponse.fromIntent(responseIntent)
        val exception = AuthorizationException.fromIntent(responseIntent)
        if (response == null || exception != null) {
            throw OidcClientException(AuthFailure.AUTHORIZATION_FAILED, exception)
        }
        validateResponse(profile, response)

        val issuer = response.request.configuration.discoveryDoc?.issuer
            ?: throw OidcClientException(AuthFailure.INVALID_CONFIGURATION)
        val state = AuthState(response, null)
        val service = AuthorizationService(applicationContext)
        val tokenResponse = try {
            suspendCancellableCoroutine { continuation ->
                try {
                    service.performTokenRequest(response.createTokenExchangeRequest()) { token, error ->
                        if (continuation.isActive) {
                            continuation.resume(token to error)
                        }
                    }
                } catch (error: Exception) {
                    if (continuation.isActive) {
                        continuation.resume(null to AuthorizationException.fromTemplate(
                            AuthorizationException.GeneralErrors.NETWORK_ERROR,
                            error,
                        ))
                    }
                }
            }
        } finally {
            service.dispose()
        }
        state.update(tokenResponse.first, tokenResponse.second)
        if (tokenResponse.first == null || tokenResponse.second != null || !state.isAuthorized) {
            throw OidcClientException(AuthFailure.TOKEN_EXCHANGE_FAILED, tokenResponse.second)
        }
        return PersistedOidcSession(
            issuer = issuer,
            authStateJson = state.jsonSerializeString(),
        )
    }

    override suspend fun freshAccessToken(
        profile: InstanceProfile,
        authStateJson: String,
    ): FreshOidcToken {
        val state = deserializeState(profile, authStateJson)
        val service = AuthorizationService(applicationContext)
        val result = try {
            suspendCancellableCoroutine { continuation ->
                try {
                    state.performActionWithFreshTokens(service) { accessToken, _, error ->
                        if (continuation.isActive) {
                            continuation.resume(accessToken to error)
                        }
                    }
                } catch (error: Exception) {
                    if (continuation.isActive) {
                        continuation.resume(null to error)
                    }
                }
            }
        } finally {
            service.dispose()
        }
        val accessToken = result.first
        if (accessToken.isNullOrBlank() || result.second != null) {
            throw OidcClientException(AuthFailure.TOKEN_REFRESH_FAILED, result.second)
        }
        return FreshOidcToken(
            accessToken = accessToken,
            authStateJson = state.jsonSerializeString(),
        )
    }

    override suspend fun revoke(
        profile: InstanceProfile,
        authStateJson: String,
    ): RemoteRevocation {
        val state = deserializeState(profile, authStateJson)
        val token = state.refreshToken ?: state.accessToken ?: return RemoteRevocation.UNAVAILABLE
        val tokenHint = if (state.refreshToken != null) "refresh_token" else "access_token"
        val revocationUrl = profile.baseUrl.toHttpUrl().resolve("application/o/revoke/")
            ?: return RemoteRevocation.UNAVAILABLE
        val request = Request.Builder()
            .url(revocationUrl)
            .post(
                FormBody.Builder()
                    .add("client_id", AuthConfiguration.CLIENT_ID)
                    .add("token", token)
                    .add("token_type_hint", tokenHint)
                    .build(),
            )
            .build()

        return try {
            withContext(Dispatchers.IO) {
                apiClientFactory.create(profile).okHttpClient.newCall(request).execute().use { response ->
                    if (response.isSuccessful) RemoteRevocation.COMPLETED else RemoteRevocation.FAILED
                }
            }
        } catch (error: CancellationException) {
            throw error
        } catch (_: Exception) {
            RemoteRevocation.FAILED
        }
    }

    private suspend fun discover(profile: InstanceProfile): AuthorizationServiceConfiguration =
        suspendCancellableCoroutine { continuation ->
            AuthorizationServiceConfiguration.fetchFromUrl(
                AuthConfiguration.discoveryUrl(profile),
                { configuration, error ->
                    if (!continuation.isActive) {
                        return@fetchFromUrl
                    }
                    if (configuration == null || error != null) {
                        continuation.resumeWith(
                            Result.failure(OidcClientException(AuthFailure.DISCOVERY_FAILED, error)),
                        )
                    } else {
                        try {
                            AuthorizationRequestFactory.validate(profile, configuration)
                            val issuer = configuration.discoveryDoc?.issuer
                                ?: throw IllegalArgumentException("Discovery document has no issuer.")
                            AuthStateCodec.encode(profile, issuer, "{}")
                            continuation.resume(configuration)
                        } catch (validationError: Exception) {
                            continuation.resumeWith(
                                Result.failure(
                                    OidcClientException(
                                        AuthFailure.INVALID_CONFIGURATION,
                                        validationError,
                                    ),
                                ),
                            )
                        }
                    }
                },
            )
        }

    private fun validateResponse(profile: InstanceProfile, response: AuthorizationResponse) {
        val request = response.request
        try {
            AuthorizationRequestFactory.validate(profile, request.configuration)
            require(request.clientId == AuthConfiguration.CLIENT_ID)
            require(request.redirectUri.toString() == AuthConfiguration.REDIRECT_URI)
            require(request.state != null && request.state == response.state)
        } catch (error: IllegalArgumentException) {
            throw OidcClientException(AuthFailure.INVALID_CONFIGURATION, error)
        }
    }

    private fun deserializeState(profile: InstanceProfile, authStateJson: String): AuthState {
        val state = try {
            AuthState.jsonDeserialize(authStateJson)
        } catch (error: Exception) {
            throw OidcClientException(AuthFailure.STORED_STATE_UNREADABLE, error)
        }
        try {
            val configuration = state.authorizationServiceConfiguration
                ?: throw IllegalArgumentException("Stored state has no service configuration.")
            AuthorizationRequestFactory.validate(profile, configuration)
        } catch (error: Exception) {
            throw OidcClientException(AuthFailure.STORED_STATE_UNREADABLE, error)
        }
        return state
    }

    private fun callbackPendingIntent(
        instanceId: InstanceId,
        cancelled: Boolean,
    ): PendingIntent {
        val kind = if (cancelled) "cancel" else "complete"
        val intent = Intent(applicationContext, AuthRedirectActivity::class.java).apply {
            action = "$CALLBACK_ACTION.$kind.${instanceId.value}"
            putExtra(AuthRedirectActivity.EXTRA_INSTANCE_ID, instanceId.value)
            putExtra(AuthRedirectActivity.EXTRA_CANCELLED, cancelled)
        }
        return PendingIntent.getActivity(
            applicationContext,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_MUTABLE,
        )
    }

    private companion object {
        const val CALLBACK_ACTION = "dev.greyfoundry.authentik.action.OIDC_CALLBACK"
    }
}
