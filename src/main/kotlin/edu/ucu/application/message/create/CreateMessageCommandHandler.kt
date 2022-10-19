package edu.ucu.application.message.create

import edu.ucu.application.message.MessageRepository
import edu.ucu.domain.message.Message
import io.micronaut.context.annotation.Prototype

@Prototype
class CreateMessageCommandHandler(
    private val messageRepository: MessageRepository
) {
    fun execute(command: CreateMessageCommand): Unit {
        val message = Message.create(command.id, command.messageText, command.createdAt)
        messageRepository.add(message)
    }
}