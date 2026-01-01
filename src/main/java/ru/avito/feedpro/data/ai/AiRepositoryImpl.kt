
package ru.avito.feedpro.data.ai

import ru.avito.feedpro.domain.model.AdText
import ru.avito.feedpro.domain.repository.AiRepository
import ru.avito.feedpro.domain.util.Result

class AiRepositoryImpl(
    private val provider: GeminiProvider
) : AiRepository {

    override suspend fun generateAdTexts(
        template: String,
        count: Int,
        uniquenessLevel: Int
    ): Result<List<AdText>> {
        return try {
            val prompt = buildPrompt(template, count, uniquenessLevel)
            val response = provider.textModel.generateContent(prompt)

            val texts = response.text
                ?.split("###")
                ?.mapIndexed { index, block ->
                    AdText(
                        title = "Объявление ${index + 1}",
                        description = block.trim(),
                        price = 1000 + index
                    )
                }
                ?: emptyList()

            Result.Success(texts)
        } catch (e: Exception) {
            Result.Error("Ошибка генерации текста", e)
        }
    }

    private fun buildPrompt(
        template: String,
        count: Int,
        uniquenessLevel: Int
    ): String =
        """ 
        Сгенерируй $count уникальных объявлений.
        Уровень уникальности: $uniquenessLevel из 3.
        Шаблон:
        $template
        Разделяй объявления через ###
        """.trimIndent()
}
