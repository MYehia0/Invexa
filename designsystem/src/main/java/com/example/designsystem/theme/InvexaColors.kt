package com.example.designsystem.theme

import androidx.compose.ui.graphics.Color
import com.example.designsystem.tokens.raw.ColorPalette
import com.example.designsystem.tokens.semantic.SemanticColors

data class InvexaExtendedColors(
    val success: Color,
    val onSuccess: Color,
    val successContainer: Color,
    val onSuccessContainer: Color,

    val warning: Color,
    val onWarning: Color,
    val warningContainer: Color,
    val onWarningContainer: Color,

    val primaryPressed: Color,
    val surfaceOverlay: Color,
    val outlineFocus: Color,

    val textSecondary: Color,
    val textTertiary: Color,
    val textDisabled: Color,
    val iconDefault: Color,
    val iconMuted: Color,
)

fun InvexaExtendedColors(semantic: SemanticColors) = InvexaExtendedColors(
    success = semantic.success,
    onSuccess = semantic.onSuccess,
    successContainer = semantic.successContainer,
    onSuccessContainer = semantic.onSuccessContainer,

    warning = semantic.warning,
    onWarning = semantic.onWarning,
    warningContainer = semantic.warningContainer,
    onWarningContainer = semantic.onWarningContainer,

    primaryPressed = semantic.primaryPressed,
    surfaceOverlay = semantic.surfaceOverlay,
    outlineFocus = semantic.outlineFocus,

    textSecondary = semantic.textSecondary,
    textTertiary = semantic.textTertiary,
    textDisabled = semantic.textDisabled,
    iconDefault = semantic.iconDefault,
    iconMuted = semantic.iconMuted,
)

data class InvexaGradients(
    val primaryButton: List<Color>,   // vertical
    val primaryHero: List<Color>,     // 135°
    val aiAccent: List<Color>,        // 140°
    val avatar: List<Color>,          // 135°
)

val InvexaGradientsInstance = InvexaGradients(
    primaryButton = listOf(ColorPalette.blue.t500, ColorPalette.blue.t600, ColorPalette.blue.t700),
    primaryHero = listOf(ColorPalette.blue.t500, ColorPalette.blue.t600, ColorPalette.violet.t800),
    aiAccent = listOf(ColorPalette.violet.t500, ColorPalette.violet.t600, ColorPalette.violet.t800),
    avatar = listOf(ColorPalette.blue.t500, ColorPalette.violet.t800),
)