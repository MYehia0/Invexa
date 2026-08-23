package com.example.designsystem.components.organisms

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.designsystem.tokens.component.BottomNavTokens
import com.example.designsystem.tokens.component.bottomNavTokens

data class BottomNavItem(
    val label: String,
    val icon: ImageVector,
)

@Composable
fun InvexaBottomNav(
    modifier: Modifier= Modifier,
    items: List<BottomNavItem>,
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit,
) {
    val tokens = bottomNavTokens()

    NavigationBar(
        modifier = modifier
            .fillMaxWidth()
            .drawBehind {
                drawLine(
                    brush = Brush.horizontalGradient(tokens.topBorderGradient),
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f),
                    strokeWidth = 1.5.dp.toPx(),
                )
            },
        containerColor = tokens.container,
    ) {
        items.take(2).forEachIndexed { index, item ->
            NavItem(
                item = item,
                tokens = tokens,
                selected = selectedIndex == index,
                onClick = {
                    onItemSelected(index)
                }
            )
        }
        Spacer(modifier = Modifier.width(72.dp))
        items.drop(2).take(2).forEachIndexed { index, item ->
            val actualIndex = index + 2
            NavItem(
                item = item,
                tokens = tokens,
                selected = selectedIndex == actualIndex,
                onClick = {
                    onItemSelected(actualIndex)
                }
            )
        }
    }
}

@Composable
private fun RowScope.NavItem(
    modifier: Modifier = Modifier,
    item: BottomNavItem,
    tokens: BottomNavTokens,
    selected: Boolean,
    onClick: () -> Unit,
) {
    val tint = if (selected) tokens.itemActive else tokens.itemInactive

    NavigationBarItem(
        modifier = modifier,
        selected = selected,
        onClick = onClick,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = tokens.itemActive,
            selectedTextColor= tokens.itemActive,
            indicatorColor = Color.Transparent,
            unselectedIconColor = tokens.itemInactive,
            unselectedTextColor = tokens.itemInactive,
            disabledIconColor = Color.Transparent,
            disabledTextColor = Color.Transparent,
        ),
        label = { Text(text = item.label, color = tint) },
        icon = {
            Icon(
                imageVector = item.icon,
                contentDescription = item.label,
                tint = tint
            )
        }
    )
}