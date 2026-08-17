package com.example.designsystem.tokens.raw

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.example.designsystem.R

object TypographySize {
    val size100 = 9.sp
    val size150 = 10.sp
    val size200 = 11.sp
    val size250 = 12.sp
    val size300 = 13.sp
    val size350 = 14.sp
    val size400 = 15.sp
    val size450 = 16.sp
    val size500 = 17.sp
    val size600 = 18.sp
    val size700 = 20.sp
    val size800 = 22.sp
    val size900 = 26.sp
    val size1000 = 32.sp
}

object TypographyWeight {
    val weightLight = FontWeight.Light
    val weightRegular = FontWeight.Normal
    val weightMedium = FontWeight.Medium
    val weightSemibold = FontWeight.SemiBold
    val weightBold = FontWeight.Bold
    val weightExtraBold = FontWeight.ExtraBold
}

object TypographyFont {
    val inter = FontFamily(
        Font(R.font.inter_regular, TypographyWeight.weightRegular),
        Font(R.font.inter_medium, TypographyWeight.weightMedium),
        Font(R.font.inter_semi_bold, TypographyWeight.weightSemibold),
        Font(R.font.inter_bold, TypographyWeight.weightBold),
        Font(R.font.inter_extra_bold, TypographyWeight.weightExtraBold),
    )
}