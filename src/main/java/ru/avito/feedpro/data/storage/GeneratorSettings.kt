
package ru.avito.feedpro.data.storage

data class GeneratorSettings(
    val copies: Int,
    val uniqueLevel: Int,
    val template: String,
    val avitoToken: String?
)
