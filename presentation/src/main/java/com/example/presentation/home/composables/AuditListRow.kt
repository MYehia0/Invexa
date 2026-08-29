package com.example.presentation.home.composables

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.designsystem.components.atoms.InvexaBadge
import com.example.designsystem.components.molecules.InvexaIconBox
import com.example.designsystem.components.molecules.InvexaListRow
import com.example.designsystem.theme.invexaColors
import com.example.designsystem.tokens.component.BadgeTone

data class AuditModelUI(
    val title: String,
    val subtitle: String?,
    val badge: String?,
    val icon: ImageVector,
    val status: AuditStatusTone,
    val onClick: () -> Unit
)
@Composable
fun AuditListRow (
    title: String,
    subtitle: String?,
    badge: String?,
    status: AuditStatusTone = AuditStatusTone.Progress,
    icon: ImageVector,
    onClick: () -> Unit
) {
    val tokens = auditListRowTokens(status)
    val badgeTone = when(status){
        AuditStatusTone.Progress -> BadgeTone.Primary
        AuditStatusTone.Completed -> BadgeTone.Success
        AuditStatusTone.Pending -> BadgeTone.Warning
        AuditStatusTone.Error -> BadgeTone.Error
    }

    InvexaListRow(
        leading = {
            InvexaIconBox(
                icon = icon,
                backgroundColor = tokens.container,
                iconTint = tokens.icon
            )
        },
        title = title,
        subtitle = subtitle,
        onClick = onClick,
        trailing = {
            badge?.let{
                InvexaBadge(
                    label = it,
                    tone = badgeTone,
                    showDot = false
                )
            }
        }
    )
}

enum class AuditStatusTone { Progress , Completed, Pending, Error }


data class AuditListRowTokens (
    val container: Color,
    val icon: Color
)

@Composable
@ReadOnlyComposable
fun auditListRowTokens(status: AuditStatusTone): AuditListRowTokens {
    val colors = MaterialTheme.colorScheme
    val extended = MaterialTheme.invexaColors

    return when (status) {
        AuditStatusTone.Progress -> AuditListRowTokens(container = colors.primaryContainer, icon = colors.primary)
        AuditStatusTone.Completed -> AuditListRowTokens(container = extended.successContainer, icon = extended.success)
        AuditStatusTone.Pending -> AuditListRowTokens(container = extended.warningContainer, icon = extended.warning)
        AuditStatusTone.Error -> AuditListRowTokens(container = colors.errorContainer, icon = colors.error)
    }
}