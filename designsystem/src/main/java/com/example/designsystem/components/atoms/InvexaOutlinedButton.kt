package com.example.designsystem.components.atoms

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.designsystem.tokens.component.ButtonSize
import com.example.designsystem.tokens.component.contentPadding
import com.example.designsystem.tokens.component.iconSize
import com.example.designsystem.tokens.component.outlinedButtonTokens
import com.example.designsystem.tokens.raw.Spacing


@Composable
fun InvexaOutlinedButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String? = null,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    isLoading: Boolean = false,
    enabled: Boolean = true,
    size: ButtonSize = ButtonSize.Medium,
) {
    val tokens = outlinedButtonTokens()
    val shape = RoundedCornerShape(tokens.shape)
    val isDisabled = isLoading || !enabled
    val borderColor = if (!isDisabled) tokens.content else tokens.content.copy(alpha = 0.38f)

    OutlinedButton(
        onClick = onClick,
        enabled = !isDisabled,
        shape = shape,
        border = BorderStroke(width = 1.dp, color = borderColor),
        colors = ButtonDefaults.outlinedButtonColors(containerColor = tokens.container),
        contentPadding = size.contentPadding(),
        modifier = modifier
    ) {
        val iconSize = size.iconSize()
        val hasLeadingIconSpacing = (text != null && leadingIcon != null) || (isLoading)
        val hasTrailingIconSpacing = (text != null && trailingIcon != null) || (isLoading)
        if (isLoading) {
            CircularProgressIndicator(
                color = tokens.content,
                strokeWidth = 2.dp,
                modifier = Modifier.size(iconSize),
            )
        } else {
            Row(verticalAlignment = Alignment.CenterVertically) {
                leadingIcon?.let {
                    Icon(imageVector = it, contentDescription = text, tint = tokens.content, modifier = Modifier.size(iconSize))
                }
                if (hasLeadingIconSpacing) Spacer(Modifier.width(Spacing.space100))
                text?.let { Text(text = it, color = tokens.content) }
                if (hasTrailingIconSpacing) Spacer(Modifier.width(Spacing.space100))
                trailingIcon?.let {
                    Icon(imageVector = it, contentDescription = text, tint = tokens.content, modifier = Modifier.size(iconSize))
                }
            }
        }
    }
}