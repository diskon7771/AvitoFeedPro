
package ru.avito.feedpro.data.storage

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.avito.feedpro.domain.model.GenerationHistory
import ru.avito.feedpro.domain.repository.HistoryRepository
import java.util.concurrent.CopyOnWriteArrayList

class HistoryRepositoryImpl : HistoryRepository {

    private val history = CopyOnWriteArrayList<GenerationHistory>()

    override suspend fun save(history: GenerationHistory) {
        withContext(Dispatchers.IO) {
            this@HistoryRepositoryImpl.history.add(history)
        }
    }

    override suspend fun getAll(): List<GenerationHistory> =
        withContext(Dispatchers.IO) {
            history.toList()
        }
}
