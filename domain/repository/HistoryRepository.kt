
package ru.avito.feedpro.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.avito.feedpro.domain.model.GenerationHistoryItem

interface HistoryRepository {
    fun observeHistory(): Flow<List<GenerationHistoryItem>>
    suspend fun add(item: GenerationHistoryItem)
}
