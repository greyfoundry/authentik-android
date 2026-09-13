package dev.greyfoundry.authentik.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.error
import androidx.compose.ui.semantics.semantics
import dev.greyfoundry.authentik.R
import dev.greyfoundry.authentik.ui.theme.AuthentikSpacing

@Composable
fun ErrorPanel(
    title: String,
    recovery: String,
    onRetry: (() -> Unit)?,
    onShowDetails: (() -> Unit)?,
    modifier: Modifier = Modifier,
) {
    val scheme = MaterialTheme.colorScheme

    Surface(
        modifier = modifier.semantics { error(recovery) },
        color = scheme.errorContainer,
        contentColor = scheme.onErrorContainer,
        shape = MaterialTheme.shapes.medium,
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            ListItem(
                colors =
                    ListItemDefaults.colors(
                        containerColor = Color.Transparent,
                        headlineColor = scheme.onErrorContainer,
                        supportingColor = scheme.onErrorContainer,
                        leadingIconColor = scheme.error,
                    ),
                headlineContent = { Text(text = title) },
                supportingContent = { Text(text = recovery) },
                leadingContent = {
                    Icon(
                        painter = painterResource(R.drawable.ic_lucide_circle_alert),
                        contentDescription = null,
                    )
                },
            )
            if (onRetry != null || onShowDetails != null) {
                FlowRow(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(
                                start = AuthentikSpacing.md,
                                end = AuthentikSpacing.md,
                                bottom = AuthentikSpacing.sm,
                            ),
                    horizontalArrangement =
                        Arrangement.spacedBy(
                            space = AuthentikSpacing.xs,
                            alignment = Alignment.End,
                        ),
                    verticalArrangement = Arrangement.spacedBy(AuthentikSpacing.xs),
                ) {
                    onShowDetails?.let { showDetails ->
                        TextButton(
                            onClick = showDetails,
                            modifier =
                                Modifier.defaultMinSize(
                                    minWidth = AuthentikSpacing.xxl,
                                    minHeight = AuthentikSpacing.xxl,
                                ),
                        ) {
                            Text(text = stringResource(R.string.action_show_details))
                        }
                    }
                    onRetry?.let { retry ->
                        Button(
                            onClick = retry,
                            modifier =
                                Modifier.defaultMinSize(
                                    minWidth = AuthentikSpacing.xxl,
                                    minHeight = AuthentikSpacing.xxl,
                                ),
                            colors =
                                ButtonDefaults.buttonColors(
                                    containerColor = scheme.error,
                                    contentColor = scheme.onError,
                                ),
                        ) {
                            Text(text = stringResource(R.string.action_retry))
                        }
                    }
                }
            }
        }
    }
}
