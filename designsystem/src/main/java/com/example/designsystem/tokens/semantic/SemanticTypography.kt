package com.example.designsystem.tokens.semantic

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.sp
import com.example.designsystem.tokens.raw.TypographyFont
import com.example.designsystem.tokens.raw.TypographySize
import com.example.designsystem.tokens.raw.TypographyWeight

private fun typographyStyle(
    size: androidx.compose.ui.unit.TextUnit,
    weight: androidx.compose.ui.text.font.FontWeight,
    lineHeight: androidx.compose.ui.unit.TextUnit,
) = TextStyle(
    fontFamily = TypographyFont.inter,
    fontSize = size,
    fontWeight = weight,
    lineHeight = lineHeight,
    lineHeightStyle = LineHeightStyle(
        alignment = LineHeightStyle.Alignment.Center,
        trim = LineHeightStyle.Trim.Both,
    ),
)

object AppTypography {
    val display = typographyStyle(TypographySize.size1000, TypographyWeight.weightExtraBold, 40.sp)
    val headline = typographyStyle(TypographySize.size900, TypographyWeight.weightExtraBold, 34.sp)
    val titleLarge = typographyStyle(TypographySize.size800, TypographyWeight.weightExtraBold, 28.sp)
    val title = typographyStyle(TypographySize.size600, TypographyWeight.weightBold, 24.sp)
    val titleSmall = typographyStyle(TypographySize.size500, TypographyWeight.weightBold, 22.sp)
    val bodyLarge = typographyStyle(TypographySize.size450, TypographyWeight.weightMedium, 22.sp)
    val body = typographyStyle(TypographySize.size350, TypographyWeight.weightRegular, 20.sp)
    val bodySmall = typographyStyle(TypographySize.size300, TypographyWeight.weightRegular, 18.sp)
    val label = typographyStyle(TypographySize.size250, TypographyWeight.weightSemibold, 16.sp)
    val caption = typographyStyle(TypographySize.size200, TypographyWeight.weightSemibold, 14.sp)
    val overline = typographyStyle(TypographySize.size150, TypographyWeight.weightBold, 14.sp)
}