
package ru.avito.feedpro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.avito.feedpro.ui.navigation.AppNavHost
import ru.avito.feedpro.ui.theme.AvitoTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AvitoTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = { ru.avito.feedpro.ui.navigation.BottomBar(navController) }
                ) { padding ->
                    AppNavHost(navController, padding)
                }
            }
        }
    }
}
