package ru.avito.feedpro.domain.repository

import ru.avito.feedpro.domain.model.GenerationHistory

interface HistoryRepository {
    suspend fun save(history: GenerationHistory)
    suspend fun getAll(): List<GenerationHistory>
}
