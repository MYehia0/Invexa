package com.example.designsystem.tokens.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.example.designsystem.theme.invexaColors
import com.example.designsystem.tokens.semantic.SemanticShapes

data class InputTokens(
    val container: Color,
    val containerError: Color,
    val border: Color,
    val borderFocused: Color,
    val borderError: Color,
    val text: Color,
    val placeholder: Color,
    val label: Color,
    val helperText: Color,
    val errorText: Color,
    val shape: Dp,
)

@Composable
@ReadOnlyComposable
fun inputTokens(): InputTokens {
    val colorScheme = MaterialTheme.colorScheme
    val extended = MaterialTheme.invexaColors
    return InputTokens(
        container = colorScheme.surface,
        containerError = colorScheme.errorContainer,
        border = colorScheme.outline,
        borderFocused = colorScheme.primary,
        borderError = colorScheme.error,
        text = extended.textPrimary,
        placeholder = extended.textTertiary,
        label = extended.textSecondary,
        helperText = extended.textTertiary,
        errorText = colorScheme.error,
        shape = SemanticShapes.shapeSM,
    )
}