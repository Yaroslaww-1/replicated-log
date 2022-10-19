package edu.ucu.infrastructure

import edu.ucu.api.configuration.DelayConfiguration
import jakarta.inject.Singleton
import kotlinx.coroutines.delay
import kotlin.time.Duration
import kotlin.time.Duration.Companion.nanoseconds

@Singleton
class DelayManager(
    private val delayConfiguration: DelayConfiguration
) {
    suspend fun delayIfEnabled() {
        if (delayConfiguration.enabled) {
            val delay = (delayConfiguration.min.toNanos()..delayConfiguration.max.toNanos()).random().nanoseconds
            delay(delay)
        }
    }
}