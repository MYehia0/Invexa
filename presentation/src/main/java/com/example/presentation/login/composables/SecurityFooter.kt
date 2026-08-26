package com.example.presentation.login.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.designsystem.icons.InvexaIcons
import com.example.designsystem.theme.invexaColors
import com.example.designsystem.tokens.raw.Spacing
import com.example.presentation.R

@Composable
fun SecurityFooter() {
    val typography = MaterialTheme.typography
    val extend = MaterialTheme.invexaColors
    val colors = MaterialTheme.colorScheme

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(colors.background)
            .padding(vertical = Spacing.space200),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = InvexaIcons.Shield,
            contentDescription = null,
            tint = extend.textTertiary.copy(alpha = 0.8f),
            modifier = Modifier.size(14.dp)
        )
        Spacer(modifier = Modifier.width(Spacing.space100))
        Text(
            text = stringResource(id = R.string.secured_by_enterprise),
            color = extend.textTertiary.copy(alpha = 0.8f),
            style = typography.bodySmall,
        )
    }
}