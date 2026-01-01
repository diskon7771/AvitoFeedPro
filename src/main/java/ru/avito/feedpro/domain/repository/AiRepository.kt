package ru.avito.feedpro.domain.repository

import ru.avito.feedpro.domain.model.AdText
import ru.avito.feedpro.domain.util.Result

interface AiRepository {
    suspend fun generateAdTexts(
        template: String,
        count: Int,
        uniquenessLevel: Int
    ): Result<List<AdText>>
}
