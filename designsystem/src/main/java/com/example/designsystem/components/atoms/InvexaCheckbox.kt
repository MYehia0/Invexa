package com.example.designsystem.components.atoms

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.designsystem.theme.invexaColors
import com.example.designsystem.tokens.component.invexaCheckboxColors
import com.example.designsystem.tokens.raw.Spacing


@Composable
fun InvexaCheckbox(
    modifier: Modifier = Modifier,
    label: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    enabled: Boolean = true,
){
    val extended = MaterialTheme.invexaColors
    val interactionSource = remember { MutableInteractionSource() }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.clickable(
            interactionSource = interactionSource,
            indication = null,
            enabled = enabled,
        ) { onCheckedChange(!checked) },
        ){
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            enabled = enabled,
            colors = invexaCheckboxColors(),
        )

        Spacer(Modifier.width(Spacing.space100))
        Text(text = label, color = extended.textSecondary)
    }
}