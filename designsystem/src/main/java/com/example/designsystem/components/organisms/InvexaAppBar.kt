package com.example.designsystem.components.organisms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import com.example.designsystem.icons.InvexaIcons
import com.example.designsystem.tokens.component.appBarTokens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InvexaAppBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    onBackClick: (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
) {
    val tokens = appBarTokens()
    val typography = MaterialTheme.typography

    TopAppBar(
        modifier = modifier
            .fillMaxWidth()
            .background(tokens.container)
            .drawBehind {
                drawLine(
                    color = tokens.border,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = 1.dp.toPx(),
                )
            },
        navigationIcon = {
            onBackClick?.let {
                IconButton(onClick = it) {
                    Icon(
                        InvexaIcons.Back,
                        contentDescription = "Back",
                        tint = tokens.icon,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        },
        title = {
            title?.let {
                Text(
                    it,
                    color = tokens.title,
                    style = typography.titleMedium,
                )
            }
        },
        actions = actions
    )
}