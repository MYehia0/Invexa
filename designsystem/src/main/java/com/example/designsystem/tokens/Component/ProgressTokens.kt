package com.example.designsystem.tokens.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.invexaColors

enum class ProgressTone { Primary, Success, Warning, Error }

data class ProgressTokens(
    val track: Color,
    val indicator: Color,
    val height: Dp,
)

@Composable
@ReadOnlyComposable
fun progressTokens(tone: ProgressTone = ProgressTone.Primary): ProgressTokens {
    val colorScheme = androidx.compose.material3.MaterialTheme.colorScheme
    val extended = MaterialTheme.invexaColors
    val indicator = when (tone) {
        ProgressTone.Primary -> colorScheme.primary
        ProgressTone.Success -> extended.success
        ProgressTone.Warning -> extended.warning
        ProgressTone.Error -> colorScheme.error
    }
    return ProgressTokens(
        track = colorScheme.surfaceVariant,
        indicator = indicator,
        height = 6.dp
    )
}