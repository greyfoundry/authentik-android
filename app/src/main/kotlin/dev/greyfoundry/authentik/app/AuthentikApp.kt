package dev.greyfoundry.authentik.app

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import dev.greyfoundry.authentik.ui.navigation.AppNavigation
import dev.greyfoundry.authentik.ui.onboarding.InstanceSetupScreen
import dev.greyfoundry.authentik.ui.onboarding.InstanceSetupViewModel
import dev.greyfoundry.authentik.ui.theme.AuthentikTheme

@Composable
fun AuthentikApp(container: AppContainer) {
    val activeInstance = container.instanceRepository.activeInstance.collectAsStateWithLifecycle()
    AuthentikTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            if (activeInstance.value == null) {
                val setupViewModel = viewModel<InstanceSetupViewModel>(
                    factory = viewModelFactory {
                        initializer {
                            InstanceSetupViewModel(
                                savedStateHandle = createSavedStateHandle(),
                                connectionRepository = container.instanceConnectionRepository,
                                authSessionRepository = container.authSessionRepository,
                            )
                        }
                    },
                )
                val state = setupViewModel.uiState.collectAsStateWithLifecycle()
                InstanceSetupScreen(
                    state = state.value,
                    onBaseUrlChanged = setupViewModel::onBaseUrlChanged,
                    onBaseUrlFocusChanged = setupViewModel::onBaseUrlFocusChanged,
                    onContinue = setupViewModel::connect,
                    onRetry = setupViewModel::retry,
                    onEditInstance = setupViewModel::editInstance,
                    onSignIn = setupViewModel::signIn,
                    onOpenAdvancedTls = null,
                )
            } else {
                AppNavigation()
            }
        }
    }
}
