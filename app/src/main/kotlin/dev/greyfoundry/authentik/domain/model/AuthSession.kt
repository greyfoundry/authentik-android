package dev.greyfoundry.authentik.domain.model

class AccessToken internal constructor(
    private val value: String,
) {
    init {
        require(value.isNotBlank()) { "Access token must not be blank." }
    }

    internal fun bearerValue(): String = value

    override fun toString(): String = "[redacted]"
}

sealed interface AuthSessionState {
    data class SignedOut(
        val instanceId: InstanceId?,
        val remoteRevocation: RemoteRevocation = RemoteRevocation.NOT_REQUESTED,
    ) : AuthSessionState

    data class Authorizing(val instanceId: InstanceId) : AuthSessionState

    data class Authorized(val instanceId: InstanceId) : AuthSessionState

    data class Failed(
        val instanceId: InstanceId?,
        val reason: AuthFailure,
    ) : AuthSessionState
}

enum class RemoteRevocation {
    NOT_REQUESTED,
    COMPLETED,
    UNAVAILABLE,
    FAILED,
}

enum class AuthFailure {
    INSTANCE_NOT_FOUND,
    DISCOVERY_FAILED,
    INVALID_CONFIGURATION,
    AUTHORIZATION_CANCELLED,
    AUTHORIZATION_FAILED,
    TOKEN_EXCHANGE_FAILED,
    TOKEN_REFRESH_FAILED,
    SIGNED_OUT,
    STORED_STATE_UNREADABLE,
    SECURE_STORAGE_UNAVAILABLE,
}

class AuthSessionException(
    val reason: AuthFailure,
) : Exception(messageFor(reason)) {
    private companion object {
        fun messageFor(reason: AuthFailure): String = when (reason) {
            AuthFailure.INSTANCE_NOT_FOUND -> "Instance profile was not found."
            AuthFailure.DISCOVERY_FAILED -> "The authentik authorization service could not be discovered."
            AuthFailure.INVALID_CONFIGURATION -> "The authentik authorization configuration is invalid."
            AuthFailure.AUTHORIZATION_CANCELLED -> "Authorization was cancelled."
            AuthFailure.AUTHORIZATION_FAILED -> "Authorization did not complete."
            AuthFailure.TOKEN_EXCHANGE_FAILED -> "Authorization code exchange failed."
            AuthFailure.TOKEN_REFRESH_FAILED -> "The access token could not be refreshed."
            AuthFailure.SIGNED_OUT -> "This instance is signed out."
            AuthFailure.STORED_STATE_UNREADABLE -> "Stored authorization state could not be read."
            AuthFailure.SECURE_STORAGE_UNAVAILABLE -> "Secure credential storage is unavailable."
        }
    }
}
