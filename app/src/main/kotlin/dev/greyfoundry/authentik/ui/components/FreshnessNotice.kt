package dev.greyfoundry.authentik.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import dev.greyfoundry.authentik.R
import dev.greyfoundry.authentik.ui.theme.AuthentikSpacing
import dev.greyfoundry.authentik.ui.theme.authentikColors

data class FreshnessUiModel(
    val state: State,
    val updatedAtLabel: String?,
) {
    enum class State {
        FRESH,
        STALE,
        OFFLINE,
    }
}

@Composable
fun FreshnessNotice(
    model: FreshnessUiModel,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val presentation = freshnessPresentation(model.state)

    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.surfaceContainerHigh,
        shape = MaterialTheme.shapes.medium,
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            ListItem(
                colors = ListItemDefaults.colors(containerColor = Color.Transparent),
                headlineContent = {
                    Text(text = stringResource(presentation.title))
                },
                supportingContent =
                    model.updatedAtLabel?.let { updatedAtLabel ->
                        {
                            Text(
                                text =
                                    stringResource(
                                        R.string.freshness_updated_at,
                                        updatedAtLabel,
                                    ),
                            )
                        }
                    },
                leadingContent = {
                    Icon(
                        painter = painterResource(presentation.icon),
                        contentDescription = null,
                        tint = presentation.iconColor,
                    )
                },
            )
            TextButton(
                onClick = onRefresh,
                modifier =
                    Modifier
                        .align(Alignment.End)
                        .padding(
                            end = AuthentikSpacing.xs,
                            bottom = AuthentikSpacing.xxs,
                        )
                        .defaultMinSize(
                            minWidth = AuthentikSpacing.xxl,
                            minHeight = AuthentikSpacing.xxl,
                        ),
            ) {
                Text(text = stringResource(R.string.action_refresh))
            }
        }
    }
}

private data class FreshnessPresentation(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val iconColor: Color,
)

@Composable
private fun freshnessPresentation(state: FreshnessUiModel.State): FreshnessPresentation {
    val extended = MaterialTheme.authentikColors
    return when (state) {
        FreshnessUiModel.State.FRESH ->
            FreshnessPresentation(
                title = R.string.freshness_fresh,
                icon = R.drawable.ic_lucide_circle_check,
                iconColor = extended.success,
            )
        FreshnessUiModel.State.STALE ->
            FreshnessPresentation(
                title = R.string.freshness_stale,
                icon = R.drawable.ic_lucide_triangle_alert,
                iconColor = extended.warning,
            )
        FreshnessUiModel.State.OFFLINE ->
            FreshnessPresentation(
                title = R.string.freshness_offline,
                icon = R.drawable.ic_lucide_wifi_off,
                iconColor = extended.stale,
            )
    }
}
