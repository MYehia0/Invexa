package com.example.designsystem.preview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.designsystem.components.atoms.InvexaButton
import com.example.designsystem.components.atoms.InvexaOutlinedButton
import com.example.designsystem.theme.InvexaTheme
import com.example.designsystem.tokens.raw.Spacing

@Composable
fun Screen(){
    InvexaTheme(
        darkTheme = false
    ) {
        Scaffold { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                Row(
                    modifier = Modifier
                        .padding(Spacing.space400)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(Spacing.space400)
                ){
                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(Spacing.space400)
                    ) {
                        InvexaButton(
                            onClick = { },
                            enabled = true,
                            leadingIcon = Icons.Default.Add,
                            modifier = Modifier.fillMaxWidth()
                        )
                        InvexaButton(
                            text = "Click Me",
                            onClick = { },
                            enabled = true,
                            leadingIcon = Icons.Default.Add,
                            modifier = Modifier.fillMaxWidth()
                        )
                        InvexaButton(
                            text = "Click Me",
                            onClick = { },
                            enabled = true,
                            trailingIcon = Icons.Default.Add,
                            modifier = Modifier.fillMaxWidth()
                        )
                        InvexaButton(
                            text = "Click Me",
                            onClick = { },
                            enabled = true,
                            isLoading = true,
                            leadingIcon = Icons.Default.Add,
                            modifier = Modifier.fillMaxWidth()
                        )
                        InvexaButton(
                            text = "Click Me",
                            onClick = { },
                            enabled = false,
                            leadingIcon = Icons.Default.Add,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(Spacing.space400)
                    ) {
                        InvexaOutlinedButton(
                            onClick = { },
                            enabled = true,
                            leadingIcon = Icons.Default.Add,
                            modifier = Modifier.fillMaxWidth()
                        )
                        InvexaOutlinedButton(
                            text = "Click Me",
                            onClick = { },
                            enabled = true,
                            leadingIcon = Icons.Default.Add,
                            modifier = Modifier.fillMaxWidth()
                        )
                        InvexaOutlinedButton(
                            text = "Click Me",
                            onClick = { },
                            enabled = true,
                            trailingIcon = Icons.Default.Add,
                            modifier = Modifier.fillMaxWidth()
                        )
                        InvexaOutlinedButton(
                            text = "Click Me",
                            onClick = { },
                            enabled = true,
                            isLoading = true,
                            leadingIcon = Icons.Default.Add,
                            modifier = Modifier.fillMaxWidth()
                        )
                        InvexaOutlinedButton(
                            text = "Click Me",
                            onClick = { },
                            enabled = false,
                            leadingIcon = Icons.Default.Add,
                            modifier = Modifier.fillMaxWidth()
                        )
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