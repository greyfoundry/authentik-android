package dev.greyfoundry.authentik.auth

import android.content.Intent
import dev.greyfoundry.authentik.domain.model.AccessToken
import dev.greyfoundry.authentik.domain.model.AuthFailure
import dev.greyfoundry.authentik.domain.model.AuthSessionException
import dev.greyfoundry.authentik.domain.model.AuthSessionState
import dev.greyfoundry.authentik.domain.model.InstanceId
import dev.greyfoundry.authentik.domain.model.InstanceProfile
import dev.greyfoundry.authentik.domain.model.RemoteRevocation
import dev.greyfoundry.authentik.domain.repository.AuthSessionRepository
import dev.greyfoundry.authentik.domain.repository.InstanceRepository
import dev.greyfoundry.authentik.security.CredentialStoreException
import dev.greyfoundry.authentik.security.CredentialStoreFailure
import dev.greyfoundry.authentik.security.SecureCredentialStore
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class AppAuthSessionRepository internal constructor(
    private val instanceRepository: InstanceRepository,
    private val credentialStore: SecureCredentialStore,
    private val oidcClient: OidcClient,
    private val applicationScope: CoroutineScope,
) : AuthSessionRepository {
    private val mutableSession = MutableStateFlow<AuthSessionState>(
        AuthSessionState.SignedOut(instanceId = null),
    )
    private val refreshMutex = Mutex()
    private val refreshes = mutableMapOf<InstanceId, Deferred<AccessToken>>()
    private val signedOutInstances = mutableSetOf<InstanceId>()

    override val session: StateFlow<AuthSessionState> = mutableSession.asStateFlow()

    override suspend fun authorize(instanceId: InstanceId) {
        val profile = requireProfile(instanceId)
        refreshMutex.withLock {
            signedOutInstances.remove(instanceId)
        }
        mutableSession.value = AuthSessionState.Authorizing(instanceId)
        try {
            oidcClient.launchAuthorization(profile, instanceId)
        } catch (error: CancellationException) {
            throw error
        } catch (error: Exception) {
            val failure = error.toAuthFailure(AuthFailure.AUTHORIZATION_FAILED)
            mutableSession.value = AuthSessionState.Failed(instanceId, failure)
            throw AuthSessionException(failure)
        }
    }

    internal suspend fun consumeAuthorizationResponse(
        instanceId: InstanceId,
        responseIntent: Intent,
    ) {
        val profile = requireProfile(instanceId)
        try {
            val exchanged = oidcClient.exchangeAuthorizationResponse(profile, responseIntent)
            refreshMutex.withLock {
                if (instanceId in signedOutInstances) {
                    throw AuthSessionException(AuthFailure.SIGNED_OUT)
                }
                credentialStore.put(
                    instanceId,
                    AuthStateCodec.encode(
                        profile = profile,
                        issuer = exchanged.issuer,
                        authStateJson = exchanged.authStateJson,
                    ),
                )
            }
            mutableSession.value = AuthSessionState.Authorized(instanceId)
        } catch (error: CancellationException) {
            throw error
        } catch (error: Exception) {
            val failure = error.toAuthFailure(AuthFailure.TOKEN_EXCHANGE_FAILED)
            if (failure != AuthFailure.SIGNED_OUT) {
                mutableSession.value = AuthSessionState.Failed(instanceId, failure)
            }
            throw AuthSessionException(failure)
        }
    }

    override suspend fun accessToken(instanceId: InstanceId): AccessToken {
        val refresh = refreshMutex.withLock {
            if (instanceId in signedOutInstances) {
                throw AuthSessionException(AuthFailure.SIGNED_OUT)
            }
            refreshes[instanceId] ?: applicationScope.async {
                refreshAccessToken(instanceId)
            }.also { created ->
                refreshes[instanceId] = created
                created.invokeOnCompletion {
                    applicationScope.launch {
                        refreshMutex.withLock {
                            if (refreshes[instanceId] === created) {
                                refreshes.remove(instanceId)
                            }
                        }
                    }
                }
            }
        }
        return refresh.await()
    }

    override suspend fun logout(instanceId: InstanceId, revokeRemote: Boolean) {
        val inFlightRefresh = refreshMutex.withLock {
            signedOutInstances.add(instanceId)
            refreshes.remove(instanceId)
        }
        inFlightRefresh?.cancelAndJoin()

        val profile = instanceRepository.get(instanceId)
        val storedState = runCatching { credentialStore.get(instanceId) }.getOrNull()

        credentialStore.remove(instanceId)
        mutableSession.value = AuthSessionState.SignedOut(instanceId)

        if (!revokeRemote) {
            return
        }

        val remoteResult = if (profile == null || storedState == null) {
            RemoteRevocation.UNAVAILABLE
        } else {
            try {
                val decoded = AuthStateCodec.decode(profile, storedState)
                oidcClient.revoke(profile, decoded.authStateJson)
            } catch (error: CancellationException) {
                throw error
            } catch (_: Exception) {
                RemoteRevocation.FAILED
            }
        }
        mutableSession.value = AuthSessionState.SignedOut(instanceId, remoteResult)
    }

    private suspend fun refreshAccessToken(instanceId: InstanceId): AccessToken {
        val profile = requireProfile(instanceId)
        try {
            val stored = credentialStore.get(instanceId)
                ?: throw AuthSessionException(AuthFailure.SIGNED_OUT)
            val decoded = AuthStateCodec.decode(profile, stored)
            val refreshed = oidcClient.freshAccessToken(profile, decoded.authStateJson)
            refreshMutex.withLock {
                if (instanceId in signedOutInstances) {
                    throw AuthSessionException(AuthFailure.SIGNED_OUT)
                }
                credentialStore.put(
                    instanceId,
                    AuthStateCodec.encode(profile, decoded.issuer, refreshed.authStateJson),
                )
            }
            mutableSession.value = AuthSessionState.Authorized(instanceId)
            return AccessToken(refreshed.accessToken)
        } catch (error: CancellationException) {
            throw error
        } catch (error: AuthSessionException) {
            mutableSession.value = AuthSessionState.Failed(instanceId, error.reason)
            throw error
        } catch (error: Exception) {
            val failure = error.toAuthFailure(AuthFailure.TOKEN_REFRESH_FAILED)
            mutableSession.value = AuthSessionState.Failed(instanceId, failure)
            throw AuthSessionException(failure)
        }
    }

    private suspend fun requireProfile(instanceId: InstanceId): InstanceProfile =
        instanceRepository.get(instanceId) ?: run {
            mutableSession.value = AuthSessionState.Failed(instanceId, AuthFailure.INSTANCE_NOT_FOUND)
            throw AuthSessionException(AuthFailure.INSTANCE_NOT_FOUND)
        }

    private fun Exception.toAuthFailure(fallback: AuthFailure): AuthFailure = when (this) {
        is AuthSessionException -> reason
        is OidcClientException -> reason
        is AuthStateBindingException -> AuthFailure.STORED_STATE_UNREADABLE
        is CredentialStoreException -> when (reason) {
            CredentialStoreFailure.UNAVAILABLE -> AuthFailure.SECURE_STORAGE_UNAVAILABLE
            CredentialStoreFailure.UNREADABLE -> AuthFailure.STORED_STATE_UNREADABLE
        }
        else -> fallback
    }
}
