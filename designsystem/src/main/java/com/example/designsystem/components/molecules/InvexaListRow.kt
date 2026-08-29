package com.example.designsystem.components.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.designsystem.icons.InvexaIcons
import com.example.designsystem.theme.invexaColors
import com.example.designsystem.theme.invexaShadow
import com.example.designsystem.tokens.component.cardTokens
import com.example.designsystem.tokens.component.listRowTokens
import com.example.designsystem.tokens.raw.Spacing
import com.example.designsystem.tokens.semantic.SemanticShapes

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
    val tokens = listRowTokens()
    val extended = MaterialTheme.invexaColors
    val shape = RoundedCornerShape(tokens.shape)
    val typography = MaterialTheme.typography

    Row(
        modifier = modifier
            .fillMaxWidth()
            .invexaShadow(tokens.shadow, tokens.shape)
            .background(tokens.container, shape)
            .border(1.dp, tokens.border, shape)
            .clip(shape)
            .let { if (onClick != null) it.clickable(onClick = onClick) else it }
            .padding(vertical = Spacing.space450, horizontal = Spacing.space400),

        verticalAlignment = Alignment.CenterVertically,
    ) {
        leading?.invoke()
        Spacer(Modifier.width(Spacing.space300))
        Column(modifier = Modifier.weight(1f)) {
            Text(title, color = extended.textPrimary, style = typography.titleSmall)
            subtitle?.let { Text(it, color = extended.textTertiary, style = typography.labelMedium) }
        }
        Spacer(Modifier.width(Spacing.space200))
        trailing?.invoke()
        if (showChevron) {
            Spacer(Modifier.width(Spacing.space100))
            Icon(InvexaIcons.ChevronRight, contentDescription = null, tint = extended.iconMuted)
        }
    }
}