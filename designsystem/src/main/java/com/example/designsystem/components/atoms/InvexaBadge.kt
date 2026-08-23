package com.example.designsystem.components.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.InvexaTheme
import com.example.designsystem.tokens.component.BadgeTone
import com.example.designsystem.tokens.component.badgeTokens
import com.example.designsystem.tokens.raw.Spacing

@Composable
fun InvexaBadge(
    modifier: Modifier = Modifier,
    label: String,
    tone: BadgeTone,
    showDot: Boolean = true,
) {
    val tokens = badgeTokens(tone)

    Badge(
        modifier = modifier,
        contentColor = tokens.content,
        containerColor = tokens.container,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (showDot) {
                Box(
                    modifier = Modifier
                        .size(5.dp)
                        .background(tokens.content, CircleShape),
                )
                Spacer(Modifier.width(4.dp))
            }
            Text(text = label, color = tokens.content)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun InvexaBadgePrev(){
    InvexaTheme() {
        Column(
            verticalArrangement = Arrangement.spacedBy(Spacing.space200)
        ) {
            InvexaBadge(
                modifier = Modifier,
                label = "Success",
                tone = BadgeTone.Success,
                showDot = true,
            )
            InvexaBadge(
                modifier = Modifier,
                label = "Warning",
                tone = BadgeTone.Warning,
                showDot = true,
            )

            InvexaBadge(
                modifier = Modifier,
                label = "Error",
                tone = BadgeTone.Error,
                showDot = true,
            )
            InvexaBadge(
                modifier = Modifier,
                label = "Neutral",
                tone = BadgeTone.Neutral,
                showDot = true,
            )
            InvexaBadge(
                modifier = Modifier,
                label = "Primary",
                tone = BadgeTone.Primary,
                showDot = true,
            )
        }
    }
}

