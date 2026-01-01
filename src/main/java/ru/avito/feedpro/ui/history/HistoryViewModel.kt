
package ru.avito.feedpro.ui.history

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.avito.feedpro.domain.model.GenerationHistoryItem
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor() : ViewModel() {

    private val _items = MutableStateFlow<List<GenerationHistoryItem>>(emptyList())
    val items = _items.asStateFlow()

    init {
        _items.value = listOf(
            GenerationHistoryItem("12.01.2026", 120, "Успешно"),
            GenerationHistoryItem("10.01.2026", 50, "Ошибка")
        )
    }
}
