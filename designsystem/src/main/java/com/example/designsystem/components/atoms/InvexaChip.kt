package com.example.designsystem.components.atoms

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.designsystem.tokens.component.chipTokens

@Composable
fun InvexaChip(
    label: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
){
    val tokens = chipTokens()
    val shape = RoundedCornerShape(tokens.shape)

    FilterChip(
        label = { Text(text = label) },
        modifier = modifier,
        selected = selected,
        onClick = onClick,
        shape = shape,
        enabled = enabled,
        colors = FilterChipDefaults.filterChipColors(
            labelColor = tokens.contentUnselected,
            selectedLabelColor = tokens.contentSelected,
            containerColor = tokens.containerUnselected,
            selectedContainerColor = tokens.containerSelected
        ),
        border = FilterChipDefaults.filterChipBorder(
            enabled = enabled,
            selected = selected,
            disabledBorderColor = tokens.border
        ),
    )
}