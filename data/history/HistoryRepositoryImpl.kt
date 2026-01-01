
package ru.avito.feedpro.data.history

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.avito.feedpro.domain.model.GenerationHistoryItem
import ru.avito.feedpro.domain.repository.HistoryRepository
import javax.inject.Inject

class HistoryRepositoryImpl @Inject constructor(
    private val dao: HistoryDao
) : HistoryRepository {

    override fun observeHistory(): Flow<List<GenerationHistoryItem>> =
        dao.observeHistory().map { list ->
            list.map {
                GenerationHistoryItem(
                    date = it.date,
                    count = it.count,
                    status = it.status
                )
            }
        }

    override suspend fun add(item: GenerationHistoryItem) {
        dao.insert(
            HistoryEntity(
                date = item.date,
                count = item.count,
                status = item.status
            )
        )
    }
}
