
package ru.avito.feedpro.ui.history

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.SharingStarted
import ru.avito.feedpro.domain.repository.HistoryRepository
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    repository: HistoryRepository
) : ViewModel() {

    val items: StateFlow<List<ru.avito.feedpro.domain.model.GenerationHistoryItem>> =
        repository.observeHistory()
            .stateIn(
                scope = kotlinx.coroutines.GlobalScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList()
            )
}
