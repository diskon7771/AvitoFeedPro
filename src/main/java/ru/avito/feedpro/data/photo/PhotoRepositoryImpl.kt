
package ru.avito.feedpro.data.photo

import android.graphics.BitmapFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.avito.feedpro.domain.model.PhotoAsset
import ru.avito.feedpro.domain.repository.PhotoRepository
import ru.avito.feedpro.domain.util.Result
import java.io.File

class PhotoRepositoryImpl(
    private val processor: ImageProcessor
) : PhotoRepository {

    override suspend fun uniquePhotos(
        photos: List<PhotoAsset>
    ): Result<List<PhotoAsset>> =
        withContext(Dispatchers.Default) {
            try {
                val result = photos.map {
                    val bitmap = BitmapFactory.decodeFile(it.localPath)
                    val processed = processor.process(bitmap, randomConfig())
                    val outFile = File(it.localPath.replace(".jpg", "_u.jpg"))
                    outFile.outputStream().use { os ->
                        processed.compress(Bitmap.CompressFormat.JPEG, 92, os)
                    }
                    it.copy(localPath = outFile.absolutePath)
                }
                Result.Success(result)
            } catch (e: Exception) {
                Result.Error("Ошибка обработки фото", e)
            }
        }

    private fun randomConfig(): PhotoConfig =
        PhotoConfig(
            rotateDegrees = (-2..2).random().toFloat(),
            noiseIntensity = listOf(0f, 0.2f, 0.4f).random(),
            overlayAlpha = listOf(0f, 0.05f, 0.1f).random()
        )
}
