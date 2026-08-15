package com.example.designsystem.tokens.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.example.designsystem.theme.gradients
import com.example.designsystem.theme.invexaElevation
import com.example.designsystem.tokens.semantic.ElevationLevel
import com.example.designsystem.tokens.semantic.SemanticShapes

data class ButtonPrimaryTokens(
    val containerGradient: List<Color>,
    val content: Color,
    val shadow: ElevationLevel,
    val shape: Dp,
)

@Composable
@ReadOnlyComposable
fun buttonPrimaryTokens(): ButtonPrimaryTokens {
    val colorScheme = MaterialTheme.colorScheme
    val gradients = MaterialTheme.gradients
    val elevation = MaterialTheme.invexaElevation

    return ButtonPrimaryTokens(
        containerGradient = gradients.aiAccent,
        content = colorScheme.onPrimary,
        shadow = elevation.glowPrimary,
        shape = SemanticShapes.shapeSM,
    )
}

data class ButtonSecondaryTokens(
    val container: Color,
    val border: Color,
    val content: Color,
    val shape: Dp,
)

@Composable
@ReadOnlyComposable
fun buttonSecondaryTokens(): ButtonSecondaryTokens {
    val colorScheme = MaterialTheme.colorScheme

    return ButtonSecondaryTokens(
        container = colorScheme.surface,
        border = colorScheme.outline,
        content = colorScheme.primary,
        shape = SemanticShapes.shapeSM,
    )
}