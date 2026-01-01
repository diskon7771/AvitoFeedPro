
package ru.avito.feedpro.data.ai

import ru.avito.feedpro.domain.repository.AiRepository
import ru.avito.feedpro.domain.util.Result
import ru.avito.feedpro.domain.util.retryWithBackoff
import ru.avito.feedpro.domain.model.AdText
import javax.inject.Inject

class GeminiAiRepository @Inject constructor() : AiRepository {

    override suspend fun generateTexts(prompt: String, count: Int): Result<List<AdText>> =
        try {
            retryWithBackoff {
                // здесь реальный вызов Gemini SDK
                Result.Success(List(count) { AdText("AI", "Generated text") })
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
}
