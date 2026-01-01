package ru.avito.feedpro.data.network.repository

import org.jsoup.Jsoup
import ru.avito.feedpro.domain.model.AvitoFeed
import ru.avito.feedpro.domain.repository.AvitoRepository
import ru.avito.feedpro.domain.util.Result
import ru.avito.feedpro.data.network.api.AvitoApi

class AvitoRepositoryImpl(
    private val api: AvitoApi
) : AvitoRepository {

    override suspend fun buildFeed(): Result<AvitoFeed> {
        val xml = "<xml><ad>sample</ad></xml>"
        return Result.Success(AvitoFeed(xml))
    }

    override suspend fun validateFeed(xml: String): Result<Unit> {
        return try {
            val response = api.validateFeed(xml)
            val doc = Jsoup.parse(response)

            val errors = doc.select("error")
            if (errors.isNotEmpty()) {
                Result.Error(errors.joinToString { it.text() })
            } else {
                Result.Success(Unit)
            }
        } catch (e: Exception) {
            Result.Error("Ошибка валидации Avito", e)
        }
    }
}
