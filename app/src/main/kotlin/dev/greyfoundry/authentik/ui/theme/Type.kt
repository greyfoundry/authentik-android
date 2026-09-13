package dev.greyfoundry.authentik.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily

private val MaterialTypography = Typography()

val AuthentikTypography =
    Typography(
        displayLarge = MaterialTypography.displayLarge.copy(fontFamily = FontFamily.Default),
        displayMedium = MaterialTypography.displayMedium.copy(fontFamily = FontFamily.Default),
        displaySmall = MaterialTypography.displaySmall.copy(fontFamily = FontFamily.Default),
        headlineLarge = MaterialTypography.headlineLarge.copy(fontFamily = FontFamily.Default),
        headlineMedium = MaterialTypography.headlineMedium.copy(fontFamily = FontFamily.Default),
        headlineSmall = MaterialTypography.headlineSmall.copy(fontFamily = FontFamily.Default),
        titleLarge = MaterialTypography.titleLarge.copy(fontFamily = FontFamily.Default),
        titleMedium = MaterialTypography.titleMedium.copy(fontFamily = FontFamily.Default),
        titleSmall = MaterialTypography.titleSmall.copy(fontFamily = FontFamily.Default),
        bodyLarge = MaterialTypography.bodyLarge.copy(fontFamily = FontFamily.Default),
        bodyMedium = MaterialTypography.bodyMedium.copy(fontFamily = FontFamily.Default),
        bodySmall = MaterialTypography.bodySmall.copy(fontFamily = FontFamily.Default),
        labelLarge = MaterialTypography.labelLarge.copy(fontFamily = FontFamily.Default),
        labelMedium = MaterialTypography.labelMedium.copy(fontFamily = FontFamily.Default),
        labelSmall = MaterialTypography.labelSmall.copy(fontFamily = FontFamily.Default),
    )
