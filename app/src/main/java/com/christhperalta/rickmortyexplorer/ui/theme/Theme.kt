package com.christhperalta.rickmortyexplorer.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
//    primary = Purple80,
//    secondary = PurpleGrey80,
//    tertiary = Pink80

    primary = SpaceBlue80,
    onPrimary = Cream90,
    primaryContainer = SpaceBlue70,
    onPrimaryContainer = Cream90,
    secondary = PortalGreen60,
    onSecondary = Color(0xFF0E2B12),
    secondaryContainer = PortalGreen40,
    onSecondaryContainer = Color(0xFFC8FFD2),
    tertiary = Cream90,
    onTertiary = SpaceBlue90,
    tertiaryContainer = Color(0xFF6A5A1F),
    onTertiaryContainer = Cream80,
    background = SpaceBlue90,
    onBackground = Cream90,
    surface = SpaceBlue80,
    onSurface = Cream90,
    surfaceVariant = SpaceBlue70,
    onSurfaceVariant = IceBlue60,
    outline = PortalGreen50,
    error = ErrorRed60,
    onError = ErrorRed90

)

private val LightColorScheme = lightColorScheme(

    primary = SpaceBlue80,
    onPrimary = Cream90,
    primaryContainer = SpaceBlue70,
    onPrimaryContainer = Cream90,
    secondary = PortalGreen60,
    onSecondary = Color(0xFF0E2B12),
    secondaryContainer = PortalGreen40,
    onSecondaryContainer = Color(0xFFC8FFD2),
    tertiary = Cream90,
    onTertiary = SpaceBlue90,
    tertiaryContainer = Color(0xFF6A5A1F),
    onTertiaryContainer = Cream80,
    background = SpaceBlue90,
    onBackground = Cream90,
    surface = SpaceBlue80,
    onSurface = Cream90,
    surfaceVariant = SpaceBlue70,
    onSurfaceVariant = IceBlue60,
    outline = PortalGreen50,
    error = ErrorRed60,
    onError = ErrorRed90

)

@Composable
fun RickMortyExplorerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}