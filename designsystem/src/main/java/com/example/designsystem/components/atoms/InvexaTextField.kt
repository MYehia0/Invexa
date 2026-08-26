package com.example.designsystem.components.atoms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.InvexaTheme
import com.example.designsystem.theme.invexaColors
import com.example.designsystem.tokens.component.inputTokens
import com.example.designsystem.tokens.raw.Spacing
import kotlin.Boolean


@Composable
fun InvexaTextField (
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String? = null,
    placeholder: String? = null,
    helperText: String? = null,
    errorText: String? = null,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    onTrailingIconClick: (() -> Unit)? = null,
    isPassword: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    enabled: Boolean = true,
    ){
    val tokens = inputTokens()
    val extended = MaterialTheme.invexaColors
    val typography = MaterialTheme.typography
    val colors: TextFieldColors = InvexaTextFieldDefaults.colors()
    val isError = errorText != null

    Column(modifier = modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            isError = isError,
            singleLine = maxLines == 1,
            maxLines = maxLines,
            minLines = minLines,
            label = label?.let { { Text(it) } },
            placeholder = placeholder?.let { { Text(it, color = tokens.placeholder) } },
            leadingIcon = leadingIcon?.let {
                {
                    Icon(
                        it,
                        contentDescription = null,
                        tint = extended.iconMuted,
                        modifier = Modifier.size(20.dp)
                    )
                }
            },
            trailingIcon = when {
                trailingIcon != null && onTrailingIconClick != null -> {
                    {
                        IconButton(onClick = onTrailingIconClick) {
                            Icon(
                                trailingIcon,
                                contentDescription = null,
                                tint = extended.iconMuted,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                }
                trailingIcon != null -> {
                    { Icon(trailingIcon, contentDescription = null, tint = extended.iconMuted) }
                }
                else -> null
            },
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            shape = RoundedCornerShape(tokens.shape),
            colors = colors
        )

        val caption = errorText ?: helperText
        if (caption != null) {
            Text(
                text = caption,
                color = if (isError) tokens.errorText else tokens.helperText,
                style = typography.labelMedium,
                modifier = Modifier.padding(start = Spacing.space200, top = 4.dp),

            )
        }
    }
}

object InvexaTextFieldDefaults {
    @Composable
    fun colors(): TextFieldColors {
        val tokens = inputTokens()
        val colorScheme = MaterialTheme.colorScheme

        return OutlinedTextFieldDefaults.colors(
            focusedBorderColor = tokens.borderFocused,
            unfocusedBorderColor = tokens.border,
            errorBorderColor = tokens.borderError,
            focusedContainerColor = tokens.container,
            unfocusedContainerColor = tokens.container,
            errorContainerColor = tokens.containerError,
            focusedTextColor = tokens.text,
            unfocusedTextColor = tokens.text,
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun InvexaTextFieldPreview (){
    InvexaTheme(
        darkTheme = false
    ){
        InvexaTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            placeholder = "Enter your password",
        )
    }
}