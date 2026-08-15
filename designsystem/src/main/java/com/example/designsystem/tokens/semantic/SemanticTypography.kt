package com.example.designsystem.tokens.semantic

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import com.example.designsystem.tokens.raw.TypographySize
import com.example.designsystem.tokens.raw.TypographyWeight

data class TypographyStyle(
    val size: TextUnit,
    val weight: FontWeight,
)

object AppTypography {
    val display = TypographyStyle(size = TypographySize.size1000, weight = TypographyWeight.weightExtraBold)
    val headline = TypographyStyle(size = TypographySize.size900, weight = TypographyWeight.weightExtraBold)
    val titleLarge = TypographyStyle(size = TypographySize.size800, weight = TypographyWeight.weightExtraBold)
    val title = TypographyStyle(size = TypographySize.size600, weight = TypographyWeight.weightBold)
    val titleSmall = TypographyStyle(size = TypographySize.size500, weight = TypographyWeight.weightBold)
    val bodyLarge = TypographyStyle(size = TypographySize.size450, weight = TypographyWeight.weightMedium)
    val body = TypographyStyle(size = TypographySize.size350, weight = TypographyWeight.weightRegular)
    val bodySmall = TypographyStyle(size = TypographySize.size300, weight = TypographyWeight.weightRegular)
    val label = TypographyStyle(size = TypographySize.size250, weight = TypographyWeight.weightSemibold)
    val caption = TypographyStyle(size = TypographySize.size200, weight = TypographyWeight.weightSemibold)
    val overline = TypographyStyle(size = TypographySize.size150, weight = TypographyWeight.weightBold)
}
