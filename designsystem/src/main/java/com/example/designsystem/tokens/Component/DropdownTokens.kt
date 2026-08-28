package com.example.designsystem.tokens.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.example.designsystem.theme.invexaColors
import com.example.designsystem.tokens.semantic.SemanticShapes

data class DropdownTokens(
    val container: Color,
    val border: Color,
    val borderFocused: Color,
    val label: Color,
    val text: Color,
    val placeholder: Color,
    val icon: Color,
    val menuContainer: Color,
    val itemSelectedContainer: Color,
    val itemSelectedContent: Color,
    val itemContent: Color,
    val shape: Dp,
)

@Composable
@ReadOnlyComposable
fun dropdownTokens(): DropdownTokens {
    val colorScheme = MaterialTheme.colorScheme
    val extended = MaterialTheme.invexaColors

    return DropdownTokens(
        container = colorScheme.surface,
        border = colorScheme.outline,
        borderFocused = colorScheme.primary,
        label = colorScheme.onSurface,
        text = colorScheme.onSurface,
        placeholder = extended.textTertiary,
        icon = extended.iconDefault,
        menuContainer = colorScheme.surface,
        itemSelectedContainer = colorScheme.primary,
        itemSelectedContent = colorScheme.onPrimary,
        itemContent = colorScheme.onSurface,
        shape = SemanticShapes.shapeSM,
    )
}