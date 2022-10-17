package edu.ucu.application.message.getall

import edu.ucu.application.message.MessageRepository
import io.micronaut.context.annotation.Prototype

@Prototype
class GetAllMessagesQueryHandler(
    private val messageRepository: MessageRepository
) {
    fun execute(query: GetAllMessagesQuery): GetAllMessagesResponse {
        val messages = messageRepository.getAll()

        return GetAllMessagesResponse(
            messages.map { m -> GetAllMessagesResponse.GetAllMessagesResponseItem(
                m.id(),
                m.messageText(),
                m.receivedAt(),
                m.replicatedAt()) }
        )
    }
}