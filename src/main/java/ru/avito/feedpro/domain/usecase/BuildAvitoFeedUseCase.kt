package ru.avito.feedpro.domain.usecase

import ru.avito.feedpro.domain.repository.AvitoRepository

class BuildAvitoFeedUseCase(
    private val repository: AvitoRepository
) {
    suspend operator fun invoke() = repository.buildFeed()
}
