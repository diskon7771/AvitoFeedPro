
package ru.avito.feedpro.ui.yadisk

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun YandexDiskScreen(viewModel: YandexDiskViewModel = hiltViewModel()) {
    var token by remember { mutableStateOf("") }
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text("Яндекс.Диск", style = MaterialTheme.typography.headlineMedium)

        OutlinedTextField(
            value = token,
            onValueChange = { token = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("OAuth токен") }
        )

        Button(onClick = { viewModel.upload(token) }) {
            Text("Загрузить фид")
        }

        Text(state)
    }
}
