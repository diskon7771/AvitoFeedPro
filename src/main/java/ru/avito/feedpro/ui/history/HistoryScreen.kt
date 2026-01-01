
package ru.avito.feedpro.ui.history

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HistoryScreen(viewModel: HistoryViewModel = hiltViewModel()) {
    val items by viewModel.items.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items) { item ->
            Card {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(item.date, style = MaterialTheme.typography.titleMedium)
                    Text("Количество: ${item.count}")
                    Text("Статус: ${item.status}")
                }
            }
        }
    }
}
