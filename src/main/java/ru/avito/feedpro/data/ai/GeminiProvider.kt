
package ru.avito.feedpro.data.ai

import com.google.ai.client.generativeai.GenerativeModel

class GeminiProvider(apiKey: String) {

    val textModel = GenerativeModel(
        modelName = "gemini-pro",
        apiKey = apiKey
    )

    val visionModel = GenerativeModel(
        modelName = "gemini-pro-vision",
        apiKey = apiKey
    )
}
