package com.example.designsystem.tokens.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.gradients
import com.example.designsystem.theme.invexaElevation
import com.example.designsystem.tokens.raw.Spacing
import com.example.designsystem.tokens.semantic.ElevationLevel
import com.example.designsystem.tokens.semantic.SemanticShapes

enum class ButtonSize { Small, Medium, Large }

fun ButtonSize.contentPadding(): PaddingValues = when (this) {
    ButtonSize.Small -> PaddingValues(horizontal = Spacing.space300, vertical = Spacing.space100)
    ButtonSize.Medium -> PaddingValues(horizontal = Spacing.space450, vertical = Spacing.space300)
    ButtonSize.Large -> PaddingValues(horizontal = Spacing.space600, vertical = Spacing.space400)
}

fun ButtonSize.iconSize(): Dp = when (this) {
    ButtonSize.Small -> 14.dp
    ButtonSize.Medium -> 18.dp
    ButtonSize.Large -> 20.dp
}

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
        containerGradient = gradients.primaryButton,
        content = colorScheme.onPrimary,
        shadow = elevation.glowPrimary,
        shape = SemanticShapes.shapeSM,
    )
}

data class OutlinedButtonTokens(
    val container: Color,
    val border: Color,
    val content: Color,
    val shape: Dp,
)

@Composable
@ReadOnlyComposable
fun outlinedButtonTokens(): OutlinedButtonTokens {
    val colorScheme = MaterialTheme.colorScheme

    return OutlinedButtonTokens(
        container = colorScheme.surface,
        border = colorScheme.outline,
        content = colorScheme.primary,
        shape = SemanticShapes.shapeSM,
    )
}

data class GhostButtonTokens(
    val content: Color,
    val shape: Dp,
)

@Composable
@ReadOnlyComposable
fun ghostButtonTokens(): GhostButtonTokens {
    val colorScheme = MaterialTheme.colorScheme
    return GhostButtonTokens(
        content = colorScheme.primary,
        shape = SemanticShapes.shapeSM,
    )
}

data class DangerButtonTokens(
    val container: Color,
    val content: Color,
    val shape: Dp,
)

@Composable
@ReadOnlyComposable
fun dangerButtonTokens(): DangerButtonTokens {
    val colorScheme = MaterialTheme.colorScheme
    return DangerButtonTokens(
        container = colorScheme.error,
        content = colorScheme.onError,
        shape = SemanticShapes.shapeSM,
    )
}