package com.example.designsystem.components.molecules

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.icons.InvexaIcons
import com.example.designsystem.theme.InvexaTheme
import com.example.designsystem.theme.invexaColors
import com.example.designsystem.tokens.component.inputTokens

@Composable
fun InvexaSearchBar(
    modifier: Modifier = Modifier,
    query: String,
    onQueryChange: (String) -> Unit,
    placeholder: String = "Search",
) {
    val tokens = inputTokens()
    val extended = MaterialTheme.invexaColors
    val shape = RoundedCornerShape(tokens.shape)
//    val colors: TextFieldColors = OutlinedTextFieldDefaults.colors()
    val colors: TextFieldColors = InvexaSearchBarDefaults.colors()

    Column(modifier = modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = query,
            onValueChange = onQueryChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = placeholder?.let { { Text(it, color = tokens.placeholder) } },
            leadingIcon = { Icon(imageVector = InvexaIcons.Search, contentDescription = null, tint = extended.iconMuted) },
            trailingIcon = when {
                query.isNotBlank() -> {
                    {
                        IconButton(onClick = { onQueryChange("") }) {
                            Icon(InvexaIcons.Close, contentDescription = null, tint = extended.iconMuted)
                        }
                    }
                }
                else -> null
            },
            shape = shape,
            colors = colors
        )
    }
}

object InvexaSearchBarDefaults {
    @Composable
    fun colors(): TextFieldColors {
        val tokens = inputTokens()

        return OutlinedTextFieldDefaults.colors(
            focusedBorderColor = tokens.border,
            focusedContainerColor = tokens.container,
            focusedTextColor = tokens.text,
            unfocusedBorderColor = tokens.border,
            unfocusedContainerColor = tokens.container,
            unfocusedTextColor = tokens.text,
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun InvexaSearchBarPreview (){
    InvexaTheme(
        darkTheme = false
    ){
        InvexaSearchBar(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            placeholder = "Enter your password",
            query = "",
            onQueryChange = {}
        )
    }
}