package ru.avito.feedpro.domain.usecase

import ru.avito.feedpro.domain.repository.AiRepository

class GenerateAdTextsUseCase(
    private val repository: AiRepository
) {
    suspend operator fun invoke(
        template: String,
        count: Int,
        uniquenessLevel: Int
    ) = repository.generateAdTexts(template, count, uniquenessLevel)
}
