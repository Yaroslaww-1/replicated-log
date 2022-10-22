package edu.ucu.application.message.create

import edu.ucu.application.message.MessageRepository
import edu.ucu.domain.message.Message
import edu.ucu.infrastructure.DelayManager
import io.micronaut.context.annotation.Prototype
import org.slf4j.LoggerFactory

@Prototype
class CreateMessageCommandHandler(
    private val messageRepository: MessageRepository,
    private val delayManager: DelayManager
) {
    private val logger = LoggerFactory.getLogger(CreateMessageCommandHandler::class.java)

    suspend fun execute(command: CreateMessageCommand): Unit {
        logger.info("New message received with id = ${command.id}")
        delayManager.delayIfEnabled()
        val message = Message.create(command.id, command.messageText, command.createdAt)
        messageRepository.add(message)
        logger.info("Message saved with id = ${command.id}")
    }
}