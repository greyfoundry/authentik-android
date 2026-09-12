package dev.greyfoundry.authentik.auth

import android.content.Intent
import dev.greyfoundry.authentik.domain.model.AuthFailure
import dev.greyfoundry.authentik.domain.model.InstanceId
import dev.greyfoundry.authentik.domain.model.InstanceProfile
import dev.greyfoundry.authentik.domain.model.RemoteRevocation

internal data class PersistedOidcSession(
    val issuer: String,
    val authStateJson: String,
)

internal data class FreshOidcToken(
    val accessToken: String,
    val authStateJson: String,
)

internal interface OidcClient {
    suspend fun launchAuthorization(profile: InstanceProfile, instanceId: InstanceId)

    suspend fun exchangeAuthorizationResponse(
        profile: InstanceProfile,
        responseIntent: Intent,
    ): PersistedOidcSession

    suspend fun freshAccessToken(
        profile: InstanceProfile,
        authStateJson: String,
    ): FreshOidcToken

    suspend fun revoke(
        profile: InstanceProfile,
        authStateJson: String,
    ): RemoteRevocation
}

internal class OidcClientException(
    val reason: AuthFailure,
    cause: Throwable? = null,
) : Exception("OIDC operation failed.", cause)
