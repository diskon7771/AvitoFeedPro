
package ru.avito.feedpro.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel()) {
    var count by remember { mutableStateOf(10f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text("Avito Feed Pro", style = MaterialTheme.typography.headlineLarge)

        Slider(
            value = count,
            onValueChange = { count = it },
            valueRange = 1f..500f
        )

        val loading by viewModel.loading.collectAsState()

        Button(
            modifier = Modifier.fillMaxWidth().height(56.dp),
            onClick = { viewModel.startGeneration("Шаблон", count.toInt()) }
        ) {
            if (loading) {
                CircularProgressIndicator(strokeWidth = 2.dp)
            } else {
                Text("ЗАПУСТИТЬ ГЕНЕРАТОР")
            }
        }
    }
}
