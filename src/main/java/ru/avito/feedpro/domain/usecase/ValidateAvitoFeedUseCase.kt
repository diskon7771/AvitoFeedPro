package ru.avito.feedpro.domain.usecase

import ru.avito.feedpro.domain.repository.AvitoRepository

class ValidateAvitoFeedUseCase(
    private val repository: AvitoRepository
) {
    suspend operator fun invoke(xml: String) =
        repository.validateFeed(xml)
}
