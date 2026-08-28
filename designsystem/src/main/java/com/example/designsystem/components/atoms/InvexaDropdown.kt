package com.example.designsystem.components.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import com.example.designsystem.tokens.component.dropdownTokens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InvexaDropdown(
    label: String,
    options: List<String>,
    selected: String,
    onSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    var expanded by remember { mutableStateOf(false) }
    val tokens = dropdownTokens()

    Column(modifier = modifier) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = it },
        ) {
            OutlinedTextField(
                value = selected,
                onValueChange = {},
                readOnly = true,
                label = { Text(label) },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                shape = RoundedCornerShape(tokens.shape),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = tokens.container,
                    unfocusedContainerColor = tokens.container,
                    focusedBorderColor = tokens.borderFocused,
                    unfocusedBorderColor = tokens.border,
                    focusedTextColor = tokens.text,
                    unfocusedTextColor = tokens.text,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor(ExposedDropdownMenuAnchorType.PrimaryNotEditable, enabled = true),
            )

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                containerColor = tokens.menuContainer,
                modifier = Modifier.exposedDropdownSize(),
            ) {
                options.forEach { option ->
                    val isSelected = option == selected
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = option,
                                style = TextStyle(color = if (isSelected) tokens.itemSelectedContent else tokens.itemContent),
                            )
                        },
                        onClick = {
                            onSelected(option)
                            expanded = false
                        },
                        colors = androidx.compose.material3.MenuDefaults.itemColors(
                            textColor = if (isSelected) tokens.itemSelectedContent else tokens.itemContent,
                        ),
                        modifier = if (isSelected)
                            Modifier.background(tokens.itemSelectedContainer)
                        else Modifier,
                    )
                }
            }
        }
    }
}