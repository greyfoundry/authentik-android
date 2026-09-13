package dev.greyfoundry.authentik.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import dev.greyfoundry.authentik.ui.theme.AuthentikSpacing
import dev.greyfoundry.authentik.ui.theme.authentikColors

enum class StatusTone {
    NEUTRAL,
    INFO,
    SUCCESS,
    WARNING,
    ERROR,
}

@Composable
fun StatusLabel(
    label: String,
    tone: StatusTone,
    icon: ImageVector,
    modifier: Modifier = Modifier,
) {
    val colors = statusColors(tone)

    Surface(
        modifier = modifier,
        color = colors.container,
        contentColor = colors.content,
        shape = MaterialTheme.shapes.small,
    ) {
        Row(
            modifier =
                Modifier.padding(
                    horizontal = AuthentikSpacing.xs,
                    vertical = AuthentikSpacing.xxs,
                ),
            horizontalArrangement = Arrangement.spacedBy(AuthentikSpacing.xxs),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(16.dp),
            )
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium,
            )
        }
    }
}

private data class StatusColors(
    val container: Color,
    val content: Color,
)

@Composable
private fun statusColors(tone: StatusTone): StatusColors {
    val scheme = MaterialTheme.colorScheme
    val extended = MaterialTheme.authentikColors
    return when (tone) {
        StatusTone.NEUTRAL -> StatusColors(scheme.surfaceVariant, scheme.onSurfaceVariant)
        StatusTone.INFO -> StatusColors(extended.info, extended.onInfo)
        StatusTone.SUCCESS -> StatusColors(extended.success, extended.onSuccess)
        StatusTone.WARNING -> StatusColors(extended.warning, extended.onWarning)
        StatusTone.ERROR -> StatusColors(scheme.error, scheme.onError)
    }
}
