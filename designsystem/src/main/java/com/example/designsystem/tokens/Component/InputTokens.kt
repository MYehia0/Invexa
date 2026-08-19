package com.example.designsystem.tokens.Component

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.example.designsystem.theme.gradients
import com.example.designsystem.theme.invexaColors
import com.example.designsystem.theme.invexaElevation
import com.example.designsystem.tokens.semantic.ElevationLevel
import com.example.designsystem.tokens.semantic.SemanticShapes

data class InputTokens(
    val container: Color,
    val border: Color,
    val borderFocus: Color,
    val content: Color,
    val shape: Dp,
)

@Composable
@ReadOnlyComposable
fun inputTokens(): InputTokens {
    val colorScheme = MaterialTheme.colorScheme
    val colorExtendScheme = MaterialTheme.invexaColors
    return InputTokens(
        container = colorScheme.surface,
        border = colorScheme.outline,
        borderFocus = colorExtendScheme.outlineFocus,
        content = colorScheme.primary,
        shape = SemanticShapes.shapeSM,
    )
}