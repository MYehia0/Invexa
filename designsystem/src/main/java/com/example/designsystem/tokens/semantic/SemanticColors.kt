package com.example.designsystem.tokens.semantic

import androidx.compose.ui.graphics.Color
import com.example.designsystem.tokens.raw.ColorPalette

data class SemanticColors(
    // Brand & state
    val primary: Color,
    val onPrimary: Color,
    val primaryContainer: Color,
    val onPrimaryContainer: Color,
    val primaryPressed: Color,

    val accent: Color,
    val onAccent: Color,
    val accentContainer: Color,
    val onAccentContainer: Color,

    val success: Color,
    val onSuccess: Color,
    val successContainer: Color,
    val onSuccessContainer: Color,

    val warning: Color,
    val onWarning: Color,
    val warningContainer: Color,
    val onWarningContainer: Color,

    val error: Color,
    val onError: Color,
    val errorContainer: Color,
    val onErrorContainer: Color,

    // Surfaces & backgrounds
    val background: Color,
    val onBackground: Color,
    val surface: Color,
    val onSurface: Color,
    val surfaceRaised: Color,
    val surfaceOverlay: Color,
    val scrim: Color,

    val outline: Color,
    val outlineSoft: Color,
    val outlineFocus: Color,

    val textPrimary: Color,
    val textSecondary: Color,
    val textTertiary: Color,
    val textDisabled: Color,
    val textDefault: Color,
    val textMuted: Color,
    val iconDefault: Color,
    val iconMuted: Color,
    val appBarHome: Color
)

val LightSemanticColors = SemanticColors(
    primary = ColorPalette.blue.t600,
    onPrimary = ColorPalette.neutral.n0,
    primaryContainer = ColorPalette.blue.t100,
    onPrimaryContainer = ColorPalette.blue.t700,
    primaryPressed = ColorPalette.blue.t700,

    accent = ColorPalette.violet.t600,
    onAccent = ColorPalette.neutral.n0,
    accentContainer = ColorPalette.violet.t100,
    onAccentContainer = ColorPalette.violet.t700,

    success = ColorPalette.green.t600,
    onSuccess = ColorPalette.neutral.n0,
    successContainer = ColorPalette.green.t100,
    onSuccessContainer = ColorPalette.green.t700,

    warning = ColorPalette.amber.t600,
    onWarning = ColorPalette.neutral.n0,
    warningContainer = ColorPalette.amber.t100,
    onWarningContainer = ColorPalette.amber.t700,

    error = ColorPalette.red.t600,
    onError = ColorPalette.neutral.n0,
    errorContainer = ColorPalette.red.t50,
    onErrorContainer = ColorPalette.red.t700,

    background = ColorPalette.neutral.n25,
    onBackground = ColorPalette.neutral.n900,
    surface = ColorPalette.neutral.n0,
    onSurface = ColorPalette.neutral.n900,
    surfaceRaised = ColorPalette.neutral.n0,
    surfaceOverlay = ColorPalette.neutral.n0,
    scrim = ColorPalette.neutral.n950.copy(alpha = 0.4f),

    // Borders & outlines
    outline = ColorPalette.neutral.n200,
    outlineSoft = ColorPalette.neutral.n100,
    outlineFocus = ColorPalette.blue.t600,

    // Text & icons
    textPrimary = ColorPalette.neutral.n900,
    textSecondary = ColorPalette.neutral.n600,
    textTertiary = ColorPalette.neutral.n500,
    textDisabled = ColorPalette.neutral.n400,
    textDefault = ColorPalette.neutral.n700,
    textMuted = ColorPalette.neutral.n400,
    iconDefault = ColorPalette.neutral.n700,
    iconMuted = ColorPalette.neutral.n400,
    appBarHome = ColorPalette.blue.t500,
)

val DarkSemanticColors = SemanticColors(
    primary = ColorPalette.blue.t400,
    onPrimary = ColorPalette.neutral.n950,
    primaryContainer = ColorPalette.blue.t800,
    onPrimaryContainer = ColorPalette.blue.t100,
    primaryPressed = ColorPalette.blue.t300,

    accent = ColorPalette.violet.t400,
    onAccent = ColorPalette.neutral.n950,
    accentContainer = ColorPalette.violet.t800,
    onAccentContainer = ColorPalette.violet.t100,

    success = ColorPalette.green.t400,
    onSuccess = ColorPalette.neutral.n950,
    successContainer = ColorPalette.green.t800,
    onSuccessContainer = ColorPalette.green.t50,

    warning = ColorPalette.amber.t400,
    onWarning = ColorPalette.neutral.n950,
    warningContainer = ColorPalette.amber.t800,
    onWarningContainer = ColorPalette.amber.t50,

    error = ColorPalette.red.t400,
    onError = ColorPalette.neutral.n950,
    errorContainer = ColorPalette.red.t800,
    onErrorContainer = ColorPalette.red.t50,

    background = ColorPalette.neutralDark.background,
    onBackground = ColorPalette.neutralDark.text100,
    surface = ColorPalette.neutralDark.surface,
    onSurface = ColorPalette.neutralDark.text100,
    surfaceRaised = ColorPalette.neutralDark.surfaceRaised,
    surfaceOverlay = ColorPalette.neutralDark.surfaceRaised,
    scrim = ColorPalette.neutral.n950.copy(alpha = 0.6f),

    outline = ColorPalette.neutralDark.border,
    outlineSoft = ColorPalette.neutralDark.borderSoft,
    outlineFocus = ColorPalette.blue.t400,

    textPrimary = ColorPalette.neutralDark.text100,
    textSecondary = ColorPalette.neutralDark.text300,
    textTertiary = ColorPalette.neutralDark.text500,
    textDisabled =  ColorPalette.neutralDark.text500.copy(alpha = 0.5f),
    textDefault = ColorPalette.neutralDark.text300,
    textMuted = ColorPalette.neutralDark.text500,
    iconDefault = ColorPalette.neutralDark.text300,
    iconMuted = ColorPalette.neutralDark.text500,
    appBarHome = ColorPalette.blue.t500,
)