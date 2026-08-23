package com.example.designsystem.tokens.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color

data class AppBarTokens(
    val container: Color,
    val title: Color,
    val icon: Color,
    val border: Color,
)

@Composable
@ReadOnlyComposable
fun appBarTokens(): AppBarTokens {
    val colorScheme = MaterialTheme.colorScheme
    return AppBarTokens(
        container = colorScheme.surface,
        title = colorScheme.onSurface,
        icon = colorScheme.onSurface,
        border = colorScheme.outlineVariant,
    )
}
