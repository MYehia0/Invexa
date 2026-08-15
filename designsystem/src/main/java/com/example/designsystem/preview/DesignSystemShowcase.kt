package com.example.designsystem.preview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.components.atoms.InvexaButton
import com.example.designsystem.theme.InvexaTheme


@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun ScreenPreview (){
    InvexaTheme(
        darkTheme = false
    ) {
        Scaffold { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding).fillMaxSize()
            ) {
                InvexaButton(
                    text = "Click Me",
                    onClick = { /* Handle click */ },
                    modifier = Modifier.padding(8.dp).fillMaxWidth()
                )
            }
        }

    }
}