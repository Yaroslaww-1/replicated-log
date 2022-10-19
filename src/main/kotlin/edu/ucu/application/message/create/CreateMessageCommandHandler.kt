package edu.ucu.application.message.create

import edu.ucu.application.message.MessageRepository
import edu.ucu.domain.message.Message
import edu.ucu.infrastructure.DelayManager
import io.micronaut.context.annotation.Prototype

@Prototype
class CreateMessageCommandHandler(
    private val messageRepository: MessageRepository,
    private val delayManager: DelayManager
) {
    suspend fun execute(command: CreateMessageCommand): Unit {
        delayManager.delayIfEnabled()
        val message = Message.create(command.id, command.messageText, command.createdAt)
        messageRepository.add(message)
    }
}