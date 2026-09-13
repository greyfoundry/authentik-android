package dev.greyfoundry.authentik.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

enum class ThemePreference {
    SYSTEM,
    LIGHT,
    DARK,
}

data class AuthentikExtendedColors(
    val success: Color,
    val onSuccess: Color,
    val warning: Color,
    val onWarning: Color,
    val info: Color,
    val onInfo: Color,
    val stale: Color,
    val onStale: Color,
)

val LocalAuthentikExtendedColors =
    staticCompositionLocalOf {
        LightAuthentikExtendedColors
    }

val MaterialTheme.authentikColors: AuthentikExtendedColors
    @Composable
    @ReadOnlyComposable
    get() = LocalAuthentikExtendedColors.current

@Composable
fun AuthentikTheme(
    preference: ThemePreference = ThemePreference.SYSTEM,
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit,
) {
    val useDarkTheme =
        when (preference) {
            ThemePreference.SYSTEM -> isSystemInDarkTheme()
            ThemePreference.LIGHT -> false
            ThemePreference.DARK -> true
        }
    val context = LocalContext.current
    val colorScheme =
        when {
            dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && useDarkTheme ->
                dynamicDarkColorScheme(context)
            dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S ->
                dynamicLightColorScheme(context)
            useDarkTheme -> AuthentikDarkColorScheme
            else -> AuthentikLightColorScheme
        }
    val extendedColors =
        if (useDarkTheme) {
            DarkAuthentikExtendedColors
        } else {
            LightAuthentikExtendedColors
        }

    CompositionLocalProvider(LocalAuthentikExtendedColors provides extendedColors) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = AuthentikTypography,
            content = content,
        )
    }
}
