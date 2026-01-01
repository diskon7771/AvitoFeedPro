
package ru.avito.feedpro.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColors = darkColorScheme(
    background = Color(0xFF000000),
    surface = Color(0xFF0D0D0D),
    primary = Color(0xFFFF5722),
    secondary = Color(0xFFFF6600),
    onPrimary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White
)

@Composable
fun AvitoTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkColors,
        content = content
    )
}
