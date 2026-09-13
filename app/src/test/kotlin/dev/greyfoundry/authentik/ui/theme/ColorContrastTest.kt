package dev.greyfoundry.authentik.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color
import kotlin.math.max
import kotlin.math.min
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ColorContrastTest {
    @Test
    fun `light fallback text pairs meet WCAG AA`() {
        assertTextContrast(staticTextPairs(AuthentikLightColorScheme))
        assertTextContrast(extendedTextPairs(LightAuthentikExtendedColors))
    }

    @Test
    fun `dark fallback text pairs meet WCAG AA`() {
        assertTextContrast(staticTextPairs(AuthentikDarkColorScheme))
        assertTextContrast(extendedTextPairs(DarkAuthentikExtendedColors))
    }

    @Test
    fun `meaningful boundaries meet non-text contrast`() {
        assertContrastAtLeast(
            name = "light outline on surface",
            foreground = AuthentikLightColorScheme.outline,
            background = AuthentikLightColorScheme.surface,
            minimum = NON_TEXT_CONTRAST,
        )
        assertContrastAtLeast(
            name = "dark outline on surface",
            foreground = AuthentikDarkColorScheme.outline,
            background = AuthentikDarkColorScheme.surface,
            minimum = NON_TEXT_CONTRAST,
        )
    }

    @Test
    fun `operational status icons meet non-text contrast`() {
        listOf(
            Triple(
                "light success",
                LightAuthentikExtendedColors.success,
                AuthentikLightColorScheme.surfaceContainerHigh,
            ),
            Triple(
                "light warning",
                LightAuthentikExtendedColors.warning,
                AuthentikLightColorScheme.surfaceContainerHigh,
            ),
            Triple(
                "light stale",
                LightAuthentikExtendedColors.stale,
                AuthentikLightColorScheme.surfaceContainerHigh,
            ),
            Triple(
                "dark success",
                DarkAuthentikExtendedColors.success,
                AuthentikDarkColorScheme.surfaceContainerHigh,
            ),
            Triple(
                "dark warning",
                DarkAuthentikExtendedColors.warning,
                AuthentikDarkColorScheme.surfaceContainerHigh,
            ),
            Triple(
                "dark stale",
                DarkAuthentikExtendedColors.stale,
                AuthentikDarkColorScheme.surfaceContainerHigh,
            ),
        ).forEach { (name, foreground, background) ->
            assertContrastAtLeast(name, foreground, background, NON_TEXT_CONTRAST)
        }
    }

    @Test
    fun `fixed brand pairs meet the design contract`() {
        assertEquals(Color(0xFF9C250E), AuthentikLightColorScheme.primary)
        assertEquals(Color.White, AuthentikLightColorScheme.onPrimary)
        assertEquals(Color(0xFFFFB4A4), AuthentikDarkColorScheme.primary)
        assertEquals(Color(0xFF5F1608), AuthentikDarkColorScheme.onPrimary)
        assertEquals(Color(0xFFFD4B2D), AuthentikBrandHighlight)

        assertContrastAtLeast(
            name = "light primary",
            foreground = AuthentikLightColorScheme.onPrimary,
            background = AuthentikLightColorScheme.primary,
            minimum = TEXT_CONTRAST,
        )
        assertContrastAtLeast(
            name = "dark primary",
            foreground = AuthentikDarkColorScheme.onPrimary,
            background = AuthentikDarkColorScheme.primary,
            minimum = TEXT_CONTRAST,
        )
        assertContrastAtLeast(
            name = "brand highlight",
            foreground = Color.Black,
            background = AuthentikBrandHighlight,
            minimum = TEXT_CONTRAST,
        )
    }

    private fun staticTextPairs(scheme: ColorScheme): List<NamedColorPair> =
        listOf(
            NamedColorPair("primary", scheme.onPrimary, scheme.primary),
            NamedColorPair("primary container", scheme.onPrimaryContainer, scheme.primaryContainer),
            NamedColorPair("secondary", scheme.onSecondary, scheme.secondary),
            NamedColorPair("secondary container", scheme.onSecondaryContainer, scheme.secondaryContainer),
            NamedColorPair("tertiary", scheme.onTertiary, scheme.tertiary),
            NamedColorPair("tertiary container", scheme.onTertiaryContainer, scheme.tertiaryContainer),
            NamedColorPair("error", scheme.onError, scheme.error),
            NamedColorPair("error container", scheme.onErrorContainer, scheme.errorContainer),
            NamedColorPair("background", scheme.onBackground, scheme.background),
            NamedColorPair("surface", scheme.onSurface, scheme.surface),
            NamedColorPair("surface variant", scheme.onSurfaceVariant, scheme.surfaceVariant),
            NamedColorPair("inverse surface", scheme.inverseOnSurface, scheme.inverseSurface),
            NamedColorPair("surface dim", scheme.onSurface, scheme.surfaceDim),
            NamedColorPair("surface bright", scheme.onSurface, scheme.surfaceBright),
            NamedColorPair("surface container lowest", scheme.onSurface, scheme.surfaceContainerLowest),
            NamedColorPair("surface container low", scheme.onSurface, scheme.surfaceContainerLow),
            NamedColorPair("surface container", scheme.onSurface, scheme.surfaceContainer),
            NamedColorPair("surface container high", scheme.onSurface, scheme.surfaceContainerHigh),
            NamedColorPair("surface container highest", scheme.onSurface, scheme.surfaceContainerHighest),
            NamedColorPair("primary fixed", scheme.onPrimaryFixed, scheme.primaryFixed),
            NamedColorPair("primary fixed variant", scheme.onPrimaryFixedVariant, scheme.primaryFixed),
            NamedColorPair("primary fixed dim", scheme.onPrimaryFixed, scheme.primaryFixedDim),
            NamedColorPair("primary fixed dim variant", scheme.onPrimaryFixedVariant, scheme.primaryFixedDim),
            NamedColorPair("secondary fixed", scheme.onSecondaryFixed, scheme.secondaryFixed),
            NamedColorPair("secondary fixed variant", scheme.onSecondaryFixedVariant, scheme.secondaryFixed),
            NamedColorPair("secondary fixed dim", scheme.onSecondaryFixed, scheme.secondaryFixedDim),
            NamedColorPair("secondary fixed dim variant", scheme.onSecondaryFixedVariant, scheme.secondaryFixedDim),
            NamedColorPair("tertiary fixed", scheme.onTertiaryFixed, scheme.tertiaryFixed),
            NamedColorPair("tertiary fixed variant", scheme.onTertiaryFixedVariant, scheme.tertiaryFixed),
            NamedColorPair("tertiary fixed dim", scheme.onTertiaryFixed, scheme.tertiaryFixedDim),
            NamedColorPair("tertiary fixed dim variant", scheme.onTertiaryFixedVariant, scheme.tertiaryFixedDim),
        )

    private fun extendedTextPairs(colors: AuthentikExtendedColors): List<NamedColorPair> =
        listOf(
            NamedColorPair("success", colors.onSuccess, colors.success),
            NamedColorPair("warning", colors.onWarning, colors.warning),
            NamedColorPair("info", colors.onInfo, colors.info),
            NamedColorPair("stale", colors.onStale, colors.stale),
        )

    private fun assertTextContrast(pairs: List<NamedColorPair>) {
        pairs.forEach { pair ->
            assertContrastAtLeast(pair.name, pair.foreground, pair.background, TEXT_CONTRAST)
        }
    }

    private fun assertContrastAtLeast(
        name: String,
        foreground: Color,
        background: Color,
        minimum: Double,
    ) {
        val actual = contrastRatio(foreground, background)
        assertTrue("$name contrast was $actual, expected at least $minimum", actual >= minimum)
    }

    private fun contrastRatio(first: Color, second: Color): Double {
        val firstLuminance = relativeLuminance(first)
        val secondLuminance = relativeLuminance(second)
        return (max(firstLuminance, secondLuminance) + 0.05) /
            (min(firstLuminance, secondLuminance) + 0.05)
    }

    private fun relativeLuminance(color: Color): Double =
        0.2126 * linearize(color.red.toDouble()) +
            0.7152 * linearize(color.green.toDouble()) +
            0.0722 * linearize(color.blue.toDouble())

    private fun linearize(component: Double): Double =
        if (component <= 0.04045) {
            component / 12.92
        } else {
            Math.pow((component + 0.055) / 1.055, 2.4)
        }

    private data class NamedColorPair(
        val name: String,
        val foreground: Color,
        val background: Color,
    )

    private companion object {
        const val TEXT_CONTRAST = 4.5
        const val NON_TEXT_CONTRAST = 3.0
    }
}
