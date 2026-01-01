package ru.avito.feedpro.domain.usecase

import ru.avito.feedpro.domain.repository.PhotoRepository
import ru.avito.feedpro.domain.model.PhotoAsset

class UniquePhotosUseCase(
    private val repository: PhotoRepository
) {
    suspend operator fun invoke(photos: List<PhotoAsset>) =
        repository.uniquePhotos(photos)
}
