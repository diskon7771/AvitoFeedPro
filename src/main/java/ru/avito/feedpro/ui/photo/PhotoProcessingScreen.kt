
package ru.avito.feedpro.ui.photo

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PhotoProcessingScreen(viewModel: PhotoViewModel = hiltViewModel()) {
    val photos by viewModel.photos.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text("Уникализация фото", style = MaterialTheme.typography.headlineMedium)

        Button(onClick = { viewModel.process() }) {
            Text("Запустить обработку")
        }

        LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            items(photos.size) {
                Text("Фото ${it + 1}")
            }
        }
    }
}
