package com.smeonlinetv.app.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val DarkBlue = Color(0xFF1E88E5)
val DarkBlueDarker = Color(0xFF0D47A1)
val DarkBlueLighter = Color(0xFF42A5F5)
val DarkBackground = Color(0xFF121212)
val DarkerBackground = Color(0xFF0A0A0A)
val SurfaceDark = Color(0xFF1E1E1E)
val TextLight = Color(0xFFFFFFFF)
val TextMedium = Color(0xFFB3B3B3)
val TextDark = Color(0xFF757575)

val DarkColorScheme = darkColorScheme(
    primary = DarkBlue,
    secondary = DarkBlueLighter,
    tertiary = DarkBlueDarker,
    background = DarkBackground,
    surface = SurfaceDark,
    onBackground = TextLight,
    onSurface = TextLight,
    onPrimary = Color.White,
)

val LightColorScheme = lightColorScheme(
    primary = DarkBlue,
    secondary = DarkBlueLighter,
    tertiary = DarkBlueDarker,
    background = Color.White,
    surface = Color(0xFFF5F5F5),
    onBackground = Color.Black,
    onSurface = Color.Black,
    onPrimary = Color.White,
)
