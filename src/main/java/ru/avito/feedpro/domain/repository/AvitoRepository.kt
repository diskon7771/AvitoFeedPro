package ru.avito.feedpro.domain.repository

import ru.avito.feedpro.domain.model.AvitoFeed
import ru.avito.feedpro.domain.util.Result

interface AvitoRepository {
    suspend fun buildFeed(): Result<AvitoFeed>
    suspend fun validateFeed(xml: String): Result<Unit>
}
