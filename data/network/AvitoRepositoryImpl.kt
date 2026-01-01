
package ru.avito.feedpro.data.network

import org.jsoup.Jsoup
import ru.avito.feedpro.domain.util.Result
import ru.avito.feedpro.domain.util.retryWithBackoff
import javax.inject.Inject

class AvitoRepositoryImpl @Inject constructor(
    private val api: AvitoApi
) {

    suspend fun validate(xml: String): Result<Unit> =
        try {
            retryWithBackoff {
                val response = api.check(xml)
                val doc = Jsoup.parse(response)
                if (doc.select("error").isNotEmpty()) {
                    throw IllegalStateException("Ошибка Avito")
                }
                Unit
            }.let { Result.Success(Unit) }
        } catch (e: Exception) {
            Result.Error(e)
        }
}
