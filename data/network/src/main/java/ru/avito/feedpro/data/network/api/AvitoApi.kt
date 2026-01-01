package ru.avito.feedpro.data.network.api

import retrofit2.http.Body
import retrofit2.http.POST

interface AvitoApi {

    @POST("/xmlcheck")
    suspend fun validateFeed(
        @Body xml: String
    ): String
}
