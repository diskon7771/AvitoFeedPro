
package ru.avito.feedpro.ui.navigation

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun BottomBar(navController: NavController) {
    NavigationBar {
        listOf(
            Routes.MAIN to "Главная",
            Routes.SETTINGS to "Настройки",
            Routes.PHOTO to "Фото",
            Routes.DISK to "Я.Диск",
            Routes.AVITO to "Avito",
            Routes.HISTORY to "История",
            Routes.READY to "Готовые"
        ).forEach { (route, label) ->
            NavigationBarItem(
                selected = false,
                onClick = { navController.navigate(route) },
                icon = {},
                label = { Text(label) }
            )
        }
    }
}
