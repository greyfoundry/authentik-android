package dev.greyfoundry.authentik.ui.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.LiveRegionMode
import androidx.compose.ui.semantics.error
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.liveRegion
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import dev.greyfoundry.authentik.R
import dev.greyfoundry.authentik.domain.model.AuthFailure
import dev.greyfoundry.authentik.domain.model.CompatibilityLevel
import dev.greyfoundry.authentik.domain.model.ConnectedInstance
import dev.greyfoundry.authentik.ui.theme.AuthentikSpacing

@Composable
fun InstanceSetupScreen(
    state: InstanceSetupUiState,
    onBaseUrlChanged: (String) -> Unit,
    onBaseUrlFocusChanged: (Boolean) -> Unit,
    onContinue: () -> Unit,
    onRetry: () -> Unit,
    onEditInstance: () -> Unit,
    onSignIn: () -> Unit,
    onOpenAdvancedTls: (() -> Unit)?,
    modifier: Modifier = Modifier,
) {
    val urlError = state.baseUrlError?.message()
    val checking = state.connection is ConnectionState.Checking
    val ready = state.connection as? ConnectionState.Ready

    Column(
        modifier =
            modifier
                .fillMaxSize()
                .safeContentPadding()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = AuthentikSpacing.phoneGutter, vertical = AuthentikSpacing.lg),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().widthIn(max = 600.dp),
            verticalArrangement = Arrangement.spacedBy(AuthentikSpacing.md),
        ) {
            Text(
                text = stringResource(R.string.onboarding_title),
                modifier = Modifier.semantics { heading() },
                style = MaterialTheme.typography.headlineMedium,
            )
            Text(
                text = stringResource(R.string.onboarding_intro),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            OutlinedTextField(
                value = state.baseUrl,
                onValueChange = onBaseUrlChanged,
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .onFocusChanged { onBaseUrlFocusChanged(it.isFocused) }
                        .then(
                            if (urlError == null) {
                                Modifier
                            } else {
                                Modifier.semantics { error(urlError) }
                            },
                        ),
                enabled = !checking && ready == null,
                label = { Text(stringResource(R.string.onboarding_instance_url_label)) },
                supportingText = {
                    Text(
                        urlError ?: stringResource(R.string.onboarding_instance_url_helper),
                    )
                },
                isError = urlError != null,
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Uri,
                    imeAction = ImeAction.Done,
                ),
            )

            when (val connection = state.connection) {
                ConnectionState.Idle -> Unit
                ConnectionState.Checking -> CheckingInstance()
                is ConnectionState.Ready -> VerifiedInstanceCard(connection.connectedInstance)
                is ConnectionState.Failed -> ConnectionFailureCard(
                    error = connection.error,
                    onOpenAdvancedTls = onOpenAdvancedTls,
                )
            }

            if (ready != null) {
                Text(
                    text = stringResource(R.string.onboarding_browser_explanation),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
                AuthorizationNotice(state.authorization)
            }

            PrimaryAction(
                state = state,
                onContinue = onContinue,
                onRetry = onRetry,
                onSignIn = onSignIn,
            )

            if (ready != null || state.connection is ConnectionState.Failed) {
                TextButton(
                    onClick = onEditInstance,
                    modifier = Modifier.heightIn(min = 48.dp),
                ) {
                    Text(stringResource(R.string.onboarding_edit_instance))
                }
            }
        }
    }
}

@Composable
private fun CheckingInstance() {
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .semantics(mergeDescendants = true) { liveRegion = LiveRegionMode.Polite }
                .padding(vertical = AuthentikSpacing.sm),
        horizontalArrangement = Arrangement.spacedBy(AuthentikSpacing.sm),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CircularProgressIndicator(modifier = Modifier.size(24.dp))
        Text(stringResource(R.string.onboarding_checking_instance))
    }
}

@Composable
private fun VerifiedInstanceCard(connected: ConnectedInstance) {
    val capabilityCount = connected.server.capabilities.size
    val compatibility = connected.server.compatibilityLevel.compatibilityLabel()
    Card(
        modifier =
            Modifier
                .fillMaxWidth()
                .semantics { liveRegion = LiveRegionMode.Polite }
                .testTag("verified-instance"),
    ) {
        Column(
            modifier = Modifier.padding(AuthentikSpacing.md),
            verticalArrangement = Arrangement.spacedBy(AuthentikSpacing.xs),
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(AuthentikSpacing.xs),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_lucide_circle_check),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                )
                Text(
                    text = stringResource(R.string.onboarding_verified_title),
                    modifier = Modifier.semantics { heading() },
                    style = MaterialTheme.typography.titleMedium,
                )
            }
            Text(
                text = connected.instance.displayName,
                style = MaterialTheme.typography.titleLarge,
            )
            Text(
                text = connected.instance.baseUrl,
                modifier = Modifier.testTag("verified-instance-url"),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            HorizontalDivider()
            InstanceFact(
                label = stringResource(R.string.onboarding_server_version),
                value = connected.server.versionCurrent,
            )
            InstanceFact(
                label = stringResource(R.string.onboarding_compatibility),
                value = compatibility,
            )
            InstanceFact(
                label = stringResource(R.string.onboarding_capabilities),
                value = pluralStringResource(
                    R.plurals.onboarding_capability_count,
                    capabilityCount,
                    capabilityCount,
                ),
            )
        }
    }
}

@Composable
private fun InstanceFact(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(AuthentikSpacing.md),
    ) {
        Text(
            text = label,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        Text(
            text = value,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

@Composable
private fun ConnectionFailureCard(
    error: InstanceConnectionError,
    onOpenAdvancedTls: (() -> Unit)?,
) {
    val title = when (error) {
        InstanceConnectionError.Tls -> stringResource(R.string.onboarding_error_tls_title)
        InstanceConnectionError.Network -> stringResource(R.string.onboarding_error_network_title)
        InstanceConnectionError.MalformedResponse -> stringResource(R.string.onboarding_error_response_title)
        InstanceConnectionError.Server -> stringResource(R.string.onboarding_error_server_title)
        is InstanceConnectionError.Unsupported -> stringResource(R.string.onboarding_error_unsupported_title)
    }
    val recovery = when (error) {
        InstanceConnectionError.Tls -> if (onOpenAdvancedTls == null) {
            stringResource(R.string.onboarding_error_tls_recovery)
        } else {
            stringResource(R.string.onboarding_error_tls_advanced_recovery)
        }
        InstanceConnectionError.Network -> stringResource(R.string.onboarding_error_network_recovery)
        InstanceConnectionError.MalformedResponse -> stringResource(R.string.onboarding_error_response_recovery)
        InstanceConnectionError.Server -> stringResource(R.string.onboarding_error_server_recovery)
        is InstanceConnectionError.Unsupported -> stringResource(
            R.string.onboarding_error_unsupported_recovery,
            error.connectedInstance.server.versionCurrent,
        )
    }
    Card(
        modifier =
            Modifier
                .fillMaxWidth()
                .semantics(mergeDescendants = true) {
                    liveRegion = LiveRegionMode.Assertive
                    error(recovery)
                },
    ) {
        Column(
            modifier = Modifier.padding(AuthentikSpacing.md),
            verticalArrangement = Arrangement.spacedBy(AuthentikSpacing.xs),
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(AuthentikSpacing.xs),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_lucide_circle_alert),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.error,
                )
                Text(title, style = MaterialTheme.typography.titleMedium)
            }
            Text(recovery, style = MaterialTheme.typography.bodyMedium)
            if (error == InstanceConnectionError.Tls && onOpenAdvancedTls != null) {
                TextButton(
                    onClick = onOpenAdvancedTls,
                    modifier = Modifier.heightIn(min = 48.dp),
                ) {
                    Text(stringResource(R.string.onboarding_advanced_tls))
                }
            }
        }
    }
}

@Composable
private fun AuthorizationNotice(authorization: AuthorizationState) {
    val text = when (authorization) {
        AuthorizationState.Idle -> return
        AuthorizationState.Launching -> stringResource(R.string.onboarding_opening_browser)
        AuthorizationState.WaitingForBrowser -> stringResource(R.string.onboarding_waiting_for_browser)
        AuthorizationState.Complete -> stringResource(R.string.onboarding_sign_in_complete)
        is AuthorizationState.Failed -> authorization.reason.authorizationError()
    }
    Text(
        text = text,
        modifier =
            Modifier.semantics {
                liveRegion = LiveRegionMode.Polite
                if (authorization is AuthorizationState.Failed) error(text)
            },
        style = MaterialTheme.typography.bodyMedium,
        color = if (authorization is AuthorizationState.Failed) {
            MaterialTheme.colorScheme.error
        } else {
            MaterialTheme.colorScheme.onSurfaceVariant
        },
    )
}

@Composable
private fun PrimaryAction(
    state: InstanceSetupUiState,
    onContinue: () -> Unit,
    onRetry: () -> Unit,
    onSignIn: () -> Unit,
) {
    val action = when (state.connection) {
        ConnectionState.Idle -> onContinue
        ConnectionState.Checking -> onContinue
        is ConnectionState.Failed -> onRetry
        is ConnectionState.Ready -> onSignIn
    }
    val label = when (state.connection) {
        ConnectionState.Idle -> stringResource(R.string.onboarding_continue)
        ConnectionState.Checking -> stringResource(R.string.onboarding_checking_instance)
        is ConnectionState.Failed -> stringResource(R.string.action_retry)
        is ConnectionState.Ready -> when (state.authorization) {
            AuthorizationState.Launching,
            AuthorizationState.WaitingForBrowser,
            -> stringResource(R.string.onboarding_waiting_for_browser)

            else -> stringResource(R.string.onboarding_sign_in_browser)
        }
    }
    val enabled = when (state.connection) {
        ConnectionState.Idle -> state.canContinue
        ConnectionState.Checking -> false
        is ConnectionState.Failed -> state.canContinue
        is ConnectionState.Ready ->
            state.authorization is AuthorizationState.Idle ||
                state.authorization is AuthorizationState.Failed
    }

    Button(
        onClick = action,
        enabled = enabled,
        modifier =
            Modifier
                .fillMaxWidth()
                .heightIn(min = 48.dp)
                .testTag("primary-action"),
    ) {
        if (state.connection is ConnectionState.Checking ||
            state.authorization is AuthorizationState.Launching
        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(20.dp),
                color = MaterialTheme.colorScheme.onPrimary,
                strokeWidth = 2.dp,
            )
        }
        Text(
            text = label,
            modifier = Modifier.padding(horizontal = AuthentikSpacing.xs),
        )
    }
}

@Composable
private fun InstanceUrlError.message(): String = when (this) {
    InstanceUrlError.REQUIRED -> stringResource(R.string.onboarding_instance_url_required)
    InstanceUrlError.HTTPS_REQUIRED -> stringResource(R.string.onboarding_instance_url_https)
    InstanceUrlError.INVALID -> stringResource(R.string.onboarding_instance_url_invalid)
}

@Composable
private fun CompatibilityLevel.compatibilityLabel(): String = when (this) {
    CompatibilityLevel.SUPPORTED -> stringResource(R.string.onboarding_compatibility_supported)
    CompatibilityLevel.DEGRADED -> stringResource(R.string.onboarding_compatibility_limited)
    CompatibilityLevel.UNSUPPORTED -> stringResource(R.string.onboarding_compatibility_unsupported)
    CompatibilityLevel.UNKNOWN -> stringResource(R.string.onboarding_compatibility_unknown)
}

@Composable
private fun AuthFailure.authorizationError(): String = when (this) {
    AuthFailure.DISCOVERY_FAILED -> stringResource(R.string.onboarding_auth_discovery_failed)
    AuthFailure.INVALID_CONFIGURATION -> stringResource(R.string.onboarding_auth_invalid_configuration)
    AuthFailure.AUTHORIZATION_CANCELLED -> stringResource(R.string.onboarding_auth_cancelled)
    AuthFailure.SECURE_STORAGE_UNAVAILABLE -> stringResource(R.string.onboarding_auth_storage_unavailable)
    else -> stringResource(R.string.onboarding_auth_failed)
}
