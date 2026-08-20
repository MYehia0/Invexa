package com.example.designsystem.tokens.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun invexaSwitchColors(): SwitchColors {
    val colorScheme = MaterialTheme.colorScheme
    return SwitchDefaults.colors(
        checkedThumbColor = colorScheme.surface,
        checkedTrackColor = colorScheme.primary,
        checkedBorderColor = colorScheme.primary,
        uncheckedThumbColor = colorScheme.surface,
        uncheckedTrackColor = colorScheme.outline,
        uncheckedBorderColor = colorScheme.outline,
    )
}