
package ru.avito.feedpro.domain.util

import kotlinx.coroutines.delay
import kotlin.math.pow

suspend fun <T> retryWithBackoff(
    attempts: Int = 5,
    initialDelay: Long = 500,
    maxDelay: Long = 5_000,
    factor: Double = 2.0,
    block: suspend () -> T
): T {
    var currentDelay = initialDelay
    repeat(attempts - 1) {
        try {
            return block()
        } catch (e: Exception) {
            delay(currentDelay)
            currentDelay = (currentDelay * factor)
                .toLong()
                .coerceAtMost(maxDelay)
        }
    }
    return block()
}
