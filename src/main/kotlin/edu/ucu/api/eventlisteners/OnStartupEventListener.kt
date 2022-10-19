package edu.ucu.api.eventlisteners

import io.micronaut.context.annotation.Value
import io.micronaut.context.event.ApplicationEventListener
import io.micronaut.context.event.StartupEvent
import jakarta.inject.Singleton
import org.slf4j.LoggerFactory

@Singleton
internal class OnStartupEventListener : ApplicationEventListener<StartupEvent?> {
    private val logger = LoggerFactory.getLogger(OnStartupEventListener::class.java)

    @Value("\${grpc.server.port}")
    var grpcServerPort: String? = null

    override fun onApplicationEvent(event: StartupEvent?) {
        logger.info("Grpc server started on port: $grpcServerPort")
    }
}