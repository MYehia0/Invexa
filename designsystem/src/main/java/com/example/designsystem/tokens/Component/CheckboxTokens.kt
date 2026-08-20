package com.example.designsystem.tokens.component

import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun invexaCheckboxColors(): CheckboxColors {
    val colorScheme = MaterialTheme.colorScheme
    return CheckboxDefaults.colors(
        checkedColor = colorScheme.primary,
        uncheckedColor = colorScheme.outline,
        checkmarkColor = colorScheme.onPrimary,
    )
}