package com.example.designsystem.components.molecules

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.designsystem.theme.invexaColors
import com.example.designsystem.tokens.raw.Spacing

@Composable
fun InvexaListRow(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String? = null,
    onClick: (() -> Unit)? = null,
    showChevron: Boolean = onClick != null,
    leading: @Composable (() -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null,
) {
    val extended = MaterialTheme.invexaColors

    Row(
        modifier = modifier
            .fillMaxWidth()
            .let { if (onClick != null) it.clickable(onClick = onClick) else it }
            .padding(vertical = Spacing.space300, horizontal = Spacing.space400),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        leading?.invoke()
        Spacer(Modifier.width(Spacing.space300))
        Column(modifier = Modifier.weight(1f)) {
            Text(title, color = extended.textPrimary)
            subtitle?.let { Text(it, color = extended.textTertiary) }
        }
        Spacer(Modifier.width(Spacing.space200))
        trailing?.invoke()
        if (showChevron) {
            Spacer(Modifier.width(Spacing.space100))
            Icon(Icons.Filled.ChevronRight, contentDescription = null, tint = extended.iconMuted)
        }
    }
}