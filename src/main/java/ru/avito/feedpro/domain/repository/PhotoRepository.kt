package ru.avito.feedpro.domain.repository

import ru.avito.feedpro.domain.model.PhotoAsset
import ru.avito.feedpro.domain.util.Result

interface PhotoRepository {
    suspend fun uniquePhotos(
        photos: List<PhotoAsset>
    ): Result<List<PhotoAsset>>
}
