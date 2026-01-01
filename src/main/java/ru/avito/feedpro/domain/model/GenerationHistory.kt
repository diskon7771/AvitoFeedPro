package ru.avito.feedpro.domain.model

import java.time.LocalDateTime

data class GenerationHistory(
    val id: Long,
    val createdAt: LocalDateTime,
    val count: Int,
    val success: Boolean
)
