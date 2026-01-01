
package ru.avito.feedpro.ui

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import ru.avito.feedpro.ui.screens.*

@Composable
fun AppRoot() {
    val nav = rememberNavController()
    MaterialTheme(colorScheme = darkColorScheme()) {
        NavHost(navController = nav, startDestination = "main") {
            composable("main") { MainScreen() }
            composable("settings") { SettingsScreen() }
            composable("photo") { PhotoProcessingScreen() }
            composable("yadisk") { YandexDiskScreen() }
            composable("avito") { AvitoAccountScreen() }
            composable("history") { HistoryScreen() }
            composable("ready") { ReadyPhotosScreen() }
        }
    }
}
