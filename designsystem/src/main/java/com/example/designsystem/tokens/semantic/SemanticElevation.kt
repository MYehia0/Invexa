package com.example.designsystem.tokens.semantic

import androidx.compose.ui.graphics.Color
import com.example.designsystem.tokens.raw.ColorPalette
import com.example.designsystem.tokens.raw.Elevation
import com.example.designsystem.tokens.raw.ShadowLayer
import com.example.designsystem.tokens.raw.dimmed

data class ElevationLevel(
    val shadows: List<ShadowLayer>,
    val borderColor: Color? = null
)

data class SemanticElevation(
    val level1: ElevationLevel,
    val level2: ElevationLevel,
    val level3: ElevationLevel,
    val glowPrimary: ElevationLevel,
    val glowAccent: ElevationLevel,
    val glowScan: ElevationLevel,
)

val LightSemanticElevation = SemanticElevation(
    level1 = ElevationLevel(shadows = Elevation.shadow100),
    level2 = ElevationLevel(shadows = Elevation.shadow200),
    level3 = ElevationLevel(shadows = Elevation.shadow300),
    glowPrimary = ElevationLevel(shadows = Elevation.glowBlue),
    glowAccent = ElevationLevel(shadows = Elevation.glowViolet),
    glowScan = ElevationLevel(shadows = Elevation.glowScan),
)

val DarkSemanticElevation = SemanticElevation(
    level1 = ElevationLevel(
        shadows = Elevation.shadow100.dimmed(2.4f),
        borderColor = ColorPalette.neutralDark.borderSoft
    ),
    level2 = ElevationLevel(
        shadows = Elevation.shadow200.dimmed(3.3f),
        borderColor = ColorPalette.neutralDark.borderSoft
    ),
    level3 = ElevationLevel(
        shadows = Elevation.shadow300.dimmed(2.8f),
        borderColor = ColorPalette.neutralDark.borderSoft
    ),
    glowPrimary = ElevationLevel(shadows = Elevation.glowBlue.dimmed(0.64f)),
    glowAccent = ElevationLevel(shadows = Elevation.glowViolet.dimmed(0.64f)),
    glowScan = ElevationLevel(shadows = Elevation.glowScan.dimmed(0.64f)),

)