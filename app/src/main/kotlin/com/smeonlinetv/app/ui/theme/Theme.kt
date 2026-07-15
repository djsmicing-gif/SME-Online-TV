package com.smeonlinetv.app.ui.theme

import androidx.compose.foundation.isSystemInDarkMode
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = PrimaryBlue,
    onPrimary = White,
    primaryContainer = PrimaryBlueDark,
    onPrimaryContainer = PrimaryBlueLightV,
    secondary = PrimaryBlueLightV,
    onSecondary = Black,
    secondaryContainer = PrimaryBlueDark,
    onSecondaryContainer = PrimaryBlueLightV,
    tertiary = TextSecondary,
    onTertiary = Black,
    tertiaryContainer = BackgroundTertiary,
    onTertiaryContainer = TextSecondary,
    error = ErrorRed,
    onError = White,
    errorContainer = Color(0xFFF9DEDC),
    onErrorContainer = ErrorRed,
    background = Background,
    onBackground = TextPrimary,
    surface = BackgroundSecondary,
    onSurface = TextPrimary,
    surfaceVariant = BackgroundTertiary,
    onSurfaceVariant = TextSecondary,
    outline = TextTertiary,
)

@Composable
fun SMEOnlineTVTheme(
    darkTheme: Boolean = isSystemInDarkMode(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}

import androidx.compose.ui.graphics.Color
