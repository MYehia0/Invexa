package com.example.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import com.example.designsystem.tokens.raw.Radius
import com.example.designsystem.tokens.semantic.AppTypography
import com.example.designsystem.tokens.semantic.DarkSemanticColors
import com.example.designsystem.tokens.semantic.DarkSemanticElevation
import com.example.designsystem.tokens.semantic.LightSemanticColors
import com.example.designsystem.tokens.semantic.LightSemanticElevation
import com.example.designsystem.tokens.semantic.SemanticColors
import com.example.designsystem.tokens.semantic.SemanticElevation
import com.example.designsystem.tokens.semantic.SemanticShapes

// --- CompositionLocals: how a value "travels" down the tree without being
// passed as a parameter through every composable in between ---
val LocalInvexaExtendedColors = staticCompositionLocalOf<InvexaExtendedColors> {
    error("No InvexaExtendedColors provided — wrap your content in InvexaTheme")
}
val LocalInvexaGradients = staticCompositionLocalOf { InvexaGradientsInstance }
val LocalInvexaElevation = staticCompositionLocalOf<SemanticElevation> {
    error("No SemanticElevation provided — wrap your content in InvexaTheme")
}

private fun invexaColorScheme(semantic: SemanticColors, dark: Boolean) =
    if (dark) {
        darkColorScheme(
            primary = semantic.primary,
            onPrimary = semantic.onPrimary,
            primaryContainer = semantic.primaryContainer,
            onPrimaryContainer = semantic.onPrimaryContainer,
            secondary = semantic.accent,
            onSecondary = semantic.onAccent,
            secondaryContainer = semantic.accentContainer,
            onSecondaryContainer = semantic.onAccentContainer,
            error = semantic.error,
            onError = semantic.onError,
            errorContainer = semantic.errorContainer,
            onErrorContainer = semantic.onErrorContainer,
            background = semantic.background,
            onBackground = semantic.onBackground,
            surface = semantic.surface,
            onSurface = semantic.onSurface,
            surfaceVariant = semantic.surfaceRaised,
            outline = semantic.outline,
            outlineVariant = semantic.outlineSoft,
            scrim = semantic.scrim,
        )
    } else {
        lightColorScheme(
            primary = semantic.primary,
            onPrimary = semantic.onPrimary,
            primaryContainer = semantic.primaryContainer,
            onPrimaryContainer = semantic.onPrimaryContainer,
            secondary = semantic.accent,
            onSecondary = semantic.onAccent,
            secondaryContainer = semantic.accentContainer,
            onSecondaryContainer = semantic.onAccentContainer,
            error = semantic.error,
            onError = semantic.onError,
            errorContainer = semantic.errorContainer,
            onErrorContainer = semantic.onErrorContainer,
            background = semantic.background,
            onBackground = semantic.onBackground,
            surface = semantic.surface,
            onSurface = semantic.onSurface,
            surfaceVariant = semantic.surfaceRaised,
            outline = semantic.outline,
            outlineVariant = semantic.outlineSoft,
            scrim = semantic.scrim,
        )
    }

private fun invexaTypography() = Typography(
    displayLarge = TextStyle(fontSize = AppTypography.display.size, fontWeight = AppTypography.display.weight),
    headlineLarge = TextStyle(fontSize = AppTypography.headline.size, fontWeight = AppTypography.headline.weight),
    titleLarge = TextStyle(fontSize = AppTypography.titleLarge.size, fontWeight = AppTypography.titleLarge.weight),
    titleMedium = TextStyle(fontSize = AppTypography.title.size, fontWeight = AppTypography.title.weight),
    titleSmall = TextStyle(fontSize = AppTypography.titleSmall.size, fontWeight = AppTypography.titleSmall.weight),
    bodyLarge = TextStyle(fontSize = AppTypography.bodyLarge.size, fontWeight = AppTypography.bodyLarge.weight),
    bodyMedium = TextStyle(fontSize = AppTypography.body.size, fontWeight = AppTypography.body.weight),
    bodySmall = TextStyle(fontSize = AppTypography.bodySmall.size, fontWeight = AppTypography.bodySmall.weight),
    labelLarge = TextStyle(fontSize = AppTypography.label.size, fontWeight = AppTypography.label.weight),
    labelMedium = TextStyle(fontSize = AppTypography.caption.size, fontWeight = AppTypography.caption.weight),
    labelSmall = TextStyle(fontSize = AppTypography.overline.size, fontWeight = AppTypography.overline.weight),
)

private val invexaShapes = Shapes(
    extraSmall = RoundedCornerShape(SemanticShapes.shapeXS),
    small = RoundedCornerShape(SemanticShapes.shapeSM),
    medium = RoundedCornerShape(SemanticShapes.shapeMD),
    large = RoundedCornerShape(SemanticShapes.shapeLG),
    extraLarge = RoundedCornerShape(SemanticShapes.shapeXL),
)

@Composable
fun InvexaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val semanticColors = if (darkTheme) DarkSemanticColors else LightSemanticColors
    val semanticElevation = if (darkTheme) DarkSemanticElevation else LightSemanticElevation
    val extendedColors = InvexaExtendedColors(semanticColors)

    CompositionLocalProvider(
        LocalInvexaExtendedColors provides extendedColors,
        LocalInvexaGradients provides InvexaGradientsInstance,
        LocalInvexaElevation provides semanticElevation,
    ) {
        MaterialTheme(
            colorScheme = invexaColorScheme(semanticColors, darkTheme),
            typography = invexaTypography(),
            shapes = invexaShapes,
            content = content
        )
    }
}