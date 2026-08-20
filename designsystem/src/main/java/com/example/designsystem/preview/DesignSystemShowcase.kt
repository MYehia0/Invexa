package com.example.designsystem.preview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.designsystem.components.atoms.InvexaButton
import com.example.designsystem.components.atoms.InvexaDangerButton
import com.example.designsystem.components.atoms.InvexaOutlinedButton
import com.example.designsystem.components.atoms.InvexaTextButton
import com.example.designsystem.components.atoms.InvexaTextField
import com.example.designsystem.theme.InvexaTheme
import com.example.designsystem.tokens.raw.Spacing

@Composable
fun Screen() {
    InvexaTheme(
        darkTheme = false
    ) {
        var fieldValue by remember { mutableStateOf("") }

        Scaffold { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                LazyColumn(
                    contentPadding = PaddingValues(Spacing.space400),
                    verticalArrangement = Arrangement.spacedBy(Spacing.space600),
                    modifier = Modifier.weight(1f),
                ){
                    item {
                        Column(verticalArrangement = Arrangement.spacedBy(Spacing.space300)) {
                            InvexaButton(text = "Primary Button", onClick = {})
                            InvexaButton(text = "Loading", onClick = {}, isLoading = true)
                            InvexaButton(text = "Disabled", onClick = {}, enabled = false)
                            InvexaOutlinedButton(text = "Outlined Button", onClick = {})
                            InvexaDangerButton(text = "Delete Audit", onClick = {})
                            InvexaTextButton(text = "Text Button", onClick = {})
                        }
                    }
                    item {
                        Column(verticalArrangement = Arrangement.spacedBy(Spacing.space300)) {
                            InvexaTextField(value = fieldValue, onValueChange = { fieldValue = it }, label = "Email", placeholder = "you@company.com")
                            InvexaTextField(value = "", onValueChange = {}, label = "Password", isPassword = true, helperText = "At least 8 characters")
                            InvexaTextField(value = "", onValueChange = {}, label = "SKU", errorText = "This field is required")
                        }
                    }
                }
            }

        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun ScreenPreview (){
    Screen()
}