package com.example.designsystem.preview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.components.atoms.InvexaButton
import com.example.designsystem.theme.InvexaTheme
import com.example.designsystem.tokens.raw.Spacing
import com.example.designsystem.tokens.semantic.SemanticShapes

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
                InvexaButton(
                    text = "Click Me",
                    onClick = { },
                    enabled = true,
                    modifier = Modifier.padding(8.dp).fillMaxWidth()
                )
                InvexaButton(
                    text = "Click Me",
                    onClick = { },
                    enabled = false,
                    modifier = Modifier.padding(8.dp).fillMaxWidth()
                )
                Button(
                    onClick = { },
                    shape = RoundedCornerShape(SemanticShapes.shapeSM),
                    contentPadding = PaddingValues(horizontal = Spacing.space450, vertical = Spacing.space300),
                    modifier = Modifier.padding(8.dp).fillMaxWidth()
                ) {
                    Text(text = "Click Me")
                }
                ElevatedButton (
                    onClick = { },
                    shape = RoundedCornerShape(SemanticShapes.shapeSM),
                    contentPadding = PaddingValues(horizontal = Spacing.space450, vertical = Spacing.space300),
                    modifier = Modifier.padding(8.dp).fillMaxWidth()
                ) {
                    Text(text = "Click Me")
                }
                FilledTonalButton (
                    onClick = { },
                    shape = RoundedCornerShape(SemanticShapes.shapeSM),
                    contentPadding = PaddingValues(horizontal = Spacing.space450, vertical = Spacing.space300),
                    modifier = Modifier.padding(8.dp).fillMaxWidth()
                ) {
                    Text(text = "Click Me")
                }
                OutlinedButton (
                    onClick = { },
                    shape = RoundedCornerShape(SemanticShapes.shapeSM),
                    contentPadding = PaddingValues(horizontal = Spacing.space450, vertical = Spacing.space300),
                    modifier = Modifier.padding(8.dp).fillMaxWidth()
                ) {
                    Text(text = "Click Me")
                }
                TextButton (
                    onClick = { },
                    shape = RoundedCornerShape(SemanticShapes.shapeSM),
                    contentPadding = PaddingValues(horizontal = Spacing.space450, vertical = Spacing.space300),
                    modifier = Modifier.padding(8.dp).fillMaxWidth()
                ) {
                    Text(text = "Click Me")
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