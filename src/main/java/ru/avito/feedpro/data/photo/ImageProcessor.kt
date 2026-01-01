
package ru.avito.feedpro.data.photo

import android.graphics.*
import kotlin.random.Random

class ImageProcessor {

    fun process(source: Bitmap, config: PhotoConfig): Bitmap {
        val mutable = source.copy(Bitmap.Config.ARGB_8888, true)
        val canvas = Canvas(mutable)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)

        if (config.rotateDegrees != 0f) {
            canvas.rotate(
                config.rotateDegrees,
                mutable.width / 2f,
                mutable.height / 2f
            )
        }

        if (config.noiseIntensity > 0f) {
            applyNoise(mutable, config.noiseIntensity)
        }

        if (config.overlayAlpha > 0f) {
            paint.color = Color.argb(
                (255 * config.overlayAlpha).toInt(),
                255, 255, 255
            )
            canvas.drawRect(
                0f, 0f,
                mutable.width.toFloat(),
                mutable.height.toFloat(),
                paint
            )
        }

        return mutable
    }

    private fun applyNoise(bitmap: Bitmap, intensity: Float) {
        for (x in 0 until bitmap.width step 2) {
            for (y in 0 until bitmap.height step 2) {
                val noise = Random.nextInt(-20, 20)
                val pixel = bitmap.getPixel(x, y)
                bitmap.setPixel(
                    x, y,
                    Color.rgb(
                        (Color.red(pixel) + noise * intensity).toInt().coerceIn(0,255),
                        (Color.green(pixel) + noise * intensity).toInt().coerceIn(0,255),
                        (Color.blue(pixel) + noise * intensity).toInt().coerceIn(0,255)
                    )
                )
            }
        }
    }
}
