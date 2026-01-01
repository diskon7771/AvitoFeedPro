
package ru.avito.feedpro.ui.avito

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AvitoAccountScreen(viewModel: AvitoAccountViewModel = hiltViewModel()) {
    var token by remember { mutableStateOf("") }
    val status by viewModel.status.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text("Аккаунт Avito", style = MaterialTheme.typography.headlineMedium)

        OutlinedTextField(
            value = token,
            onValueChange = { token = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("API токен Avito") }
        )

        Button(onClick = { viewModel.connect(token) }) {
            Text("Подключить")
        }

        Text(
            text = "Ограничения Avito: лимиты публикаций и авто-модерация",
            color = Color.Red
        )

        Text(status)
    }
}
