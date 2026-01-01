package ru.avito.feedpro.domain.usecase

import ru.avito.feedpro.domain.model.GenerationHistory
import ru.avito.feedpro.domain.repository.HistoryRepository

class SaveHistoryUseCase(
    private val repository: HistoryRepository
) {
    suspend operator fun invoke(history: GenerationHistory) =
        repository.save(history)
}
