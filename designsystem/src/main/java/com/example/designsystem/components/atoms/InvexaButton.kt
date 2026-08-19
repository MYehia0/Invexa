package com.example.designsystem.components.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.invexaShadow
import com.example.designsystem.tokens.component.buttonPrimaryTokens
import com.example.designsystem.tokens.raw.Spacing

@Composable
fun InvexaButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    onClick: () -> Unit,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
) {
    val tokens = buttonPrimaryTokens()
    val shape = RoundedCornerShape(tokens.shape)
    val isDisabled = if(isLoading) true else !enabled

    Button(
        onClick = onClick,
        enabled = !isDisabled,
        shape = shape,
        colors = ButtonDefaults.buttonColors(containerColor = Transparent),
        contentPadding = PaddingValues(horizontal = Spacing.space450, vertical = Spacing.space300),
        modifier = modifier
            .invexaShadow(tokens.shadow, tokens.shape)
            .background(brush = Brush.verticalGradient(tokens.containerGradient), shape = shape),
    ) {
        val hasLeadingIconSpacing = (text != null && leadingIcon != null) || (isLoading)
        val hasTrailingIconSpacing = (text != null && trailingIcon != null) || (isLoading)
        if (isLoading) {
            CircularProgressIndicator(
                color = tokens.content,
                strokeWidth = 2.dp,
                modifier = Modifier.size(18.dp)
            )
        } else {
            Row(verticalAlignment = Alignment.CenterVertically) {
                leadingIcon?.let { Icon(imageVector = it, contentDescription = "$text", tint = tokens.content, modifier = Modifier.size(18.dp)) }
                if (hasLeadingIconSpacing) {
                    Spacer(Modifier.width(Spacing.space100))
                }
                text?.let { Text(text = it, color = tokens.content) }
                if (hasTrailingIconSpacing) {
                    Spacer(Modifier.width(Spacing.space100))
                }
                trailingIcon?.let { Icon(imageVector = it, contentDescription = "$text", tint = tokens.content, modifier = Modifier.size(18.dp)) }
            }
        }
    }
}