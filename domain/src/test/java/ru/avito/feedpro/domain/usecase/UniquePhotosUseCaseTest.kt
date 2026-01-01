
package ru.avito.feedpro.domain.usecase

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Test
import ru.avito.feedpro.domain.model.PhotoAsset
import ru.avito.feedpro.domain.repository.PhotoRepository
import ru.avito.feedpro.domain.util.Result

private class FakePhotoRepository : PhotoRepository {
    override suspend fun unique(list: List<PhotoAsset>): Result<List<PhotoAsset>> {
        return Result.Success(list)
    }
}

class UniquePhotosUseCaseTest {

    @Test
    fun `unique photos returns same size`() = runBlocking {
        val useCase = UniquePhotosUseCase(FakePhotoRepository())
        val photos = listOf(PhotoAsset("uri1"), PhotoAsset("uri2"))

        val result = useCase(photos)

        assertTrue(result is Result.Success && result.data.size == 2)
    }
}
