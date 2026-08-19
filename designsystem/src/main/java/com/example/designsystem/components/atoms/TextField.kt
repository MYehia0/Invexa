package com.example.designsystem.components.atoms

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.InvexaTheme
import com.example.designsystem.tokens.Component.inputTokens
import kotlin.Boolean


@Composable
fun InvexaTextField (
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    label: String? = null,
    placeholder: String? = null,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
){
    val interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
    val shape: Shape = RoundedCornerShape(inputTokens().shape)
    val colors: TextFieldColors = InvexaTextFieldDefaults.colors()
    val leading = leadingIcon?.let { Icon(imageVector = it, contentDescription = "$label", tint = inputTokens().content, modifier = Modifier.size(18.dp)) }
    val trailing = trailingIcon?.let { Icon(imageVector = it, contentDescription = "$label", tint = inputTokens().content, modifier = Modifier.size(18.dp)) }
    val labelComponents = label?.let { Text(text = it, color = colors.focusedLabelColor) }
    val placeHolderComponents = placeholder?.let { Text(text = it, color = colors.focusedLabelColor) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        readOnly = readOnly,
        label = {labelComponents},
        placeholder = {placeHolderComponents},
        leadingIcon = {leading},
        trailingIcon = {trailing},
        isError = isError,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = maxLines == 1,
        maxLines = maxLines,
        minLines = minLines,
        interactionSource = interactionSource,
        shape = shape,
        colors = colors
    )
}

object InvexaTextFieldDefaults {
    @Composable
    fun colors(): TextFieldColors {
        val tokens = inputTokens()
        val colorScheme = MaterialTheme.colorScheme

        return OutlinedTextFieldDefaults.colors(
            focusedBorderColor = tokens.borderFocus,
            unfocusedBorderColor = tokens.border,
            disabledBorderColor = tokens.border.copy(alpha = 0.38f),
            errorBorderColor = colorScheme.error,
            focusedLabelColor = tokens.content,
            unfocusedLabelColor = tokens.content.copy(alpha = 0.38f),
            disabledLabelColor = tokens.content.copy(alpha = 0.38f),
            errorLabelColor = colorScheme.error,
            focusedContainerColor = tokens.container,
            unfocusedContainerColor = tokens.container,
            disabledContainerColor = tokens.container.copy(alpha = 0.38f),
            errorContainerColor = colorScheme.errorContainer,
            focusedPlaceholderColor = tokens.content.copy(alpha = 0.6f),
            unfocusedPlaceholderColor = tokens.content.copy(alpha = 0.6f)
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
//            trailingIcon = Icons.,
        )
    }
}