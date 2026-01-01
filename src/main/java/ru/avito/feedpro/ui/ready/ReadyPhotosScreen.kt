
package ru.avito.feedpro.ui.ready

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ReadyPhotosScreen(viewModel: ReadyPhotosViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text("Готовые материалы", style = MaterialTheme.typography.headlineMedium)

        Button(onClick = { viewModel.upload() }) {
            Text("Залить на Avito")
        }

        Text(state)
    }
}
