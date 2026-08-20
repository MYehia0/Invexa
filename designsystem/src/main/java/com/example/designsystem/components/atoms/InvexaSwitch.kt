package com.example.designsystem.components.atoms

import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.designsystem.tokens.component.invexaSwitchColors

@Composable
fun InvexaSwitch(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    enabled: Boolean = true,
) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        enabled = enabled,
        colors = invexaSwitchColors(),
        modifier = modifier,
    )
}