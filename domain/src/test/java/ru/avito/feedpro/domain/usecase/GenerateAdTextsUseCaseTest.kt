
package ru.avito.feedpro.domain.usecase

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Test
import ru.avito.feedpro.domain.model.AdText
import ru.avito.feedpro.domain.repository.AiRepository
import ru.avito.feedpro.domain.util.Result

private class FakeAiRepository : AiRepository {
    override suspend fun generateTexts(prompt: String, count: Int): Result<List<AdText>> {
        return Result.Success(List(count) { AdText("title", "desc $it") })
    }
}

class GenerateAdTextsUseCaseTest {

    @Test
    fun `generate returns correct count`() = runBlocking {
        val useCase = GenerateAdTextsUseCase(FakeAiRepository())
        val result = useCase("test", 3, 2)

        assertTrue(result is Result.Success && result.data.size == 3)
    }
}
