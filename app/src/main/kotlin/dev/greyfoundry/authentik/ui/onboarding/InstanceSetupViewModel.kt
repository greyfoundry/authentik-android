package dev.greyfoundry.authentik.ui.onboarding

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.greyfoundry.authentik.domain.model.AuthSessionException
import dev.greyfoundry.authentik.domain.model.AuthSessionState
import dev.greyfoundry.authentik.domain.model.CompatibilityLevel
import dev.greyfoundry.authentik.domain.model.InstanceDraft
import dev.greyfoundry.authentik.domain.model.InstanceProfile
import dev.greyfoundry.authentik.domain.model.MalformedServerResponse
import dev.greyfoundry.authentik.domain.model.NetworkUnavailable
import dev.greyfoundry.authentik.domain.model.TlsFailure
import dev.greyfoundry.authentik.domain.repository.AuthSessionRepository
import dev.greyfoundry.authentik.domain.repository.InstanceConnectionRepository
import java.net.URI
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class InstanceSetupViewModel internal constructor(
    private val savedStateHandle: SavedStateHandle,
    private val connectionRepository: InstanceConnectionRepository,
    private val authSessionRepository: AuthSessionRepository,
    workScope: CoroutineScope? = null,
) : ViewModel() {
    private val scope = workScope ?: viewModelScope
    private val initialUrl = savedStateHandle.get<String>(BASE_URL_KEY).orEmpty()
    private val mutableUiState = MutableStateFlow(
        InstanceSetupUiState(
            baseUrl = initialUrl,
            canContinue = validateUrl(initialUrl) == null,
        ),
    )
    private var connectionJob: Job? = null
    private var authorizationJob: Job? = null
    private var urlFieldWasFocused = false

    val uiState: StateFlow<InstanceSetupUiState> = mutableUiState.asStateFlow()

    init {
        scope.launch {
            authSessionRepository.session.collectLatest(::onSessionChanged)
        }
    }

    fun onBaseUrlChanged(value: String) {
        savedStateHandle[BASE_URL_KEY] = value
        mutableUiState.update { current ->
            current.copy(
                baseUrl = value,
                baseUrlError = null,
                connection = ConnectionState.Idle,
                authorization = AuthorizationState.Idle,
                canContinue = validateUrl(value) == null,
            )
        }
    }

    fun onBaseUrlFocusChanged(hasFocus: Boolean) {
        if (hasFocus) {
            urlFieldWasFocused = true
        } else if (urlFieldWasFocused) {
            showUrlValidation()
        }
    }

    fun connect() {
        if (connectionJob?.isActive == true) return
        val url = mutableUiState.value.baseUrl
        val validation = validateUrl(url)
        if (validation != null) {
            mutableUiState.update { current ->
                current.copy(baseUrlError = validation, canContinue = false)
            }
            return
        }

        connectionJob = scope.launch {
            mutableUiState.update { current ->
                current.copy(
                    baseUrlError = null,
                    connection = ConnectionState.Checking,
                    authorization = AuthorizationState.Idle,
                    canContinue = false,
                )
            }
            val result = try {
                connectionRepository.connect(url)
            } catch (error: CancellationException) {
                throw error
            } catch (error: Exception) {
                mutableUiState.update { current ->
                    current.copy(
                        connection = ConnectionState.Failed(error.toConnectionError()),
                        canContinue = true,
                    )
                }
                return@launch
            }

            mutableUiState.update { current ->
                if (result.server.compatibilityLevel == CompatibilityLevel.UNSUPPORTED) {
                    current.copy(
                        connection = ConnectionState.Failed(
                            InstanceConnectionError.Unsupported(result),
                        ),
                        canContinue = true,
                    )
                } else {
                    current.copy(
                        baseUrl = result.instance.baseUrl,
                        connection = ConnectionState.Ready(result),
                        canContinue = false,
                    )
                }
            }
            savedStateHandle[BASE_URL_KEY] = mutableUiState.value.baseUrl
        }
    }

    fun retry() = connect()

    fun editInstance() {
        mutableUiState.update { current ->
            current.copy(
                connection = ConnectionState.Idle,
                authorization = AuthorizationState.Idle,
                canContinue = validateUrl(current.baseUrl) == null,
            )
        }
    }

    fun signIn() {
        if (authorizationJob?.isActive == true) return
        val ready = mutableUiState.value.connection as? ConnectionState.Ready ?: return
        authorizationJob = scope.launch {
            mutableUiState.update { current ->
                current.copy(authorization = AuthorizationState.Launching)
            }
            try {
                authSessionRepository.authorize(ready.connectedInstance.instance.id)
                mutableUiState.update { current ->
                    current.copy(authorization = AuthorizationState.WaitingForBrowser)
                }
            } catch (error: CancellationException) {
                throw error
            } catch (error: AuthSessionException) {
                mutableUiState.update { current ->
                    current.copy(authorization = AuthorizationState.Failed(error.reason))
                }
            }
        }
    }

    private fun showUrlValidation() {
        mutableUiState.update { current ->
            val validation = validateUrl(current.baseUrl)
            current.copy(
                baseUrlError = validation,
                canContinue = validation == null && current.connection !is ConnectionState.Checking,
            )
        }
    }

    private fun onSessionChanged(session: AuthSessionState) {
        val ready = (mutableUiState.value.connection as? ConnectionState.Ready)
            ?.connectedInstance
            ?.instance
            ?.id
            ?: return
        when (session) {
            is AuthSessionState.Authorizing -> if (session.instanceId == ready) {
                mutableUiState.update { it.copy(authorization = AuthorizationState.Launching) }
            }

            is AuthSessionState.Authorized -> if (session.instanceId == ready) {
                mutableUiState.update { it.copy(authorization = AuthorizationState.Complete) }
            }

            is AuthSessionState.Failed -> if (session.instanceId == ready) {
                mutableUiState.update {
                    it.copy(authorization = AuthorizationState.Failed(session.reason))
                }
            }

            is AuthSessionState.SignedOut -> Unit
        }
    }

    private fun Exception.toConnectionError(): InstanceConnectionError = when (this) {
        is TlsFailure -> InstanceConnectionError.Tls
        is NetworkUnavailable -> InstanceConnectionError.Network
        is MalformedServerResponse -> InstanceConnectionError.MalformedResponse
        else -> InstanceConnectionError.Server
    }

    private companion object {
        const val BASE_URL_KEY = "instance_setup_base_url"

        fun validateUrl(value: String): InstanceUrlError? {
            if (value.isBlank()) return InstanceUrlError.REQUIRED
            val uri = runCatching { URI(value.trim()) }.getOrNull()
                ?: return InstanceUrlError.INVALID
            if (!uri.scheme.equals("https", ignoreCase = true)) {
                return InstanceUrlError.HTTPS_REQUIRED
            }
            return runCatching {
                InstanceProfile.create(InstanceDraft(baseUrl = value, displayName = null))
            }.fold(
                onSuccess = { null },
                onFailure = { InstanceUrlError.INVALID },
            )
        }
    }
}
