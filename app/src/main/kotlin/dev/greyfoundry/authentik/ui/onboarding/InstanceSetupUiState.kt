package dev.greyfoundry.authentik.ui.onboarding

import dev.greyfoundry.authentik.domain.model.AuthFailure
import dev.greyfoundry.authentik.domain.model.ConnectedInstance

data class InstanceSetupUiState(
    val baseUrl: String = "",
    val baseUrlError: InstanceUrlError? = null,
    val connection: ConnectionState = ConnectionState.Idle,
    val authorization: AuthorizationState = AuthorizationState.Idle,
    val canContinue: Boolean = false,
)

enum class InstanceUrlError {
    REQUIRED,
    HTTPS_REQUIRED,
    INVALID,
}

sealed interface ConnectionState {
    data object Idle : ConnectionState

    data object Checking : ConnectionState

    data class Ready(val connectedInstance: ConnectedInstance) : ConnectionState

    data class Failed(val error: InstanceConnectionError) : ConnectionState
}

sealed interface InstanceConnectionError {
    data object Tls : InstanceConnectionError

    data object Network : InstanceConnectionError

    data object MalformedResponse : InstanceConnectionError

    data object Server : InstanceConnectionError

    data class Unsupported(val connectedInstance: ConnectedInstance) : InstanceConnectionError
}

sealed interface AuthorizationState {
    data object Idle : AuthorizationState

    data object Launching : AuthorizationState

    data object WaitingForBrowser : AuthorizationState

    data object Complete : AuthorizationState

    data class Failed(val reason: AuthFailure) : AuthorizationState
}
