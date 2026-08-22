package com.example.designsystem.components.molecules

import android.widget.ProgressBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.designsystem.tokens.component.ProgressTone
import com.example.designsystem.tokens.component.progressTokens

@Composable
fun InvexaProgressBar(
    modifier: Modifier = Modifier,
    fraction: Float,
    tone: ProgressTone = ProgressTone.Primary
){
    val tokens = progressTokens(tone)
    val shape = RoundedCornerShape(tokens.height / 2)
    val clamped = fraction.coerceIn(0f, 1f)

//    LinearProgressIndicator(
//        progress = { fraction },
//        modifier = modifier.fillMaxWidth(),
//        color = tokens.indicator,
//        trackColor = tokens.track
//    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(tokens.height)
            .background(tokens.track, shape),
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(clamped)
                .background(tokens.indicator, shape),
        )
    }
}