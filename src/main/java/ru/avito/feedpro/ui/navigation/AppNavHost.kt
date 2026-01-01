
package ru.avito.feedpro.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavHost(
    navController: NavHostController,
    padding: PaddingValues
) {
    NavHost(navController, startDestination = Routes.MAIN) {
        composable(Routes.MAIN) { Text("Главная") }
        composable(Routes.SETTINGS) { Text("Настройки") }
        composable(Routes.PHOTO) { Text("Фото") }
        composable(Routes.DISK) { Text("Яндекс.Диск") }
        composable(Routes.AVITO) { Text("Avito") }
        composable(Routes.HISTORY) { Text("История") }
        composable(Routes.READY) { Text("Готовые") }
    }
}
