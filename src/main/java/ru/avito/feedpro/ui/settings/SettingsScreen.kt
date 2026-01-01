
package ru.avito.feedpro.ui.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SettingsScreen(viewModel: SettingsViewModel = hiltViewModel()) {
    var template by remember { mutableStateOf("") }
    var level by remember { mutableStateOf(2f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text("Настройки генератора", style = MaterialTheme.typography.headlineMedium)

        Slider(
            value = level,
            onValueChange = { level = it },
            valueRange = 1f..3f,
            steps = 1
        )

        OutlinedTextField(
            value = template,
            onValueChange = {
                template = it
                viewModel.generatePreview(it)
            },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Шаблон объявления") }
        )

        val preview by viewModel.preview.collectAsState()

        Text("Превью:", style = MaterialTheme.typography.titleMedium)
        Text(preview)
    }
}
