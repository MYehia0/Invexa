package com.example.designsystem.components.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.designsystem.icons.InvexaIcons
import com.example.designsystem.tokens.component.AvatarSize
import com.example.designsystem.tokens.component.avatarTokens
import com.example.designsystem.tokens.raw.Spacing


@Composable
fun InvexaAvatar(
    modifier: Modifier = Modifier,
    imageUrl: String? = null,
    initialsText: String,
    size: AvatarSize = AvatarSize.Medium,
    showCameraBadge:Boolean = false,
    onCameraClick: (() -> Unit)? = null,
){
    val tokens = avatarTokens()

    Box(modifier = modifier.size(size.diameter)) {
        if (imageUrl != null) {
            AsyncImage(
                model = imageUrl,
                contentDescription = initialsText,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(size.diameter)
                    .clip(CircleShape),
            )
        } else {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(size.diameter)
                    .background(Brush.linearGradient(tokens.avatarGradient), CircleShape)
                    .padding(Spacing.space100),
            ) {
                Text(text = initialsText, color = tokens.avatarInitialsColor, textAlign = TextAlign.Center)
            }
        }

        if(showCameraBadge){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(28.dp)
                    .align(Alignment.BottomEnd)
                    .background(tokens.avatarContainer, CircleShape)
            ) {
                Icon(
                    imageVector = InvexaIcons.Camera,
                    contentDescription = "Change photo",
                    tint = tokens.avatarContent,
                    modifier = Modifier.size(14.dp),
                )
            }
        }
    }

}