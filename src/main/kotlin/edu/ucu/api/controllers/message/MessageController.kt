package edu.ucu.api.controllers.message

import com.google.protobuf.Empty
import com.google.protobuf.util.Timestamps
import edu.ucu.CreateMessageRequest
import edu.ucu.GetAllMessagesReply
import edu.ucu.Message
import edu.ucu.SecondaryServiceGrpcKt
import edu.ucu.application.message.create.CreateMessageCommand
import edu.ucu.application.message.create.CreateMessageCommandHandler
import edu.ucu.application.message.getall.GetAllMessagesQuery
import edu.ucu.application.message.getall.GetAllMessagesQueryHandler
import jakarta.inject.Singleton
import java.time.LocalDateTime
import java.time.ZoneOffset


@Singleton
class MessageController(
    private val createMessageCommandHandler: CreateMessageCommandHandler,
    private val getAllMessagesQueryHandler: GetAllMessagesQueryHandler
): SecondaryServiceGrpcKt.SecondaryServiceCoroutineImplBase() {

    override suspend fun createMessage(request: CreateMessageRequest): Empty {
        createMessageCommandHandler.execute(CreateMessageCommand(
            request.id,
            request.messageText,
            LocalDateTime.ofEpochSecond(request.receivedAt.seconds, request.receivedAt.nanos, ZoneOffset.UTC)
        ))
        return Empty.getDefaultInstance()
    }

    override suspend fun getAllMessages(request: Empty): GetAllMessagesReply {
        val messages = getAllMessagesQueryHandler.execute(GetAllMessagesQuery())
        return GetAllMessagesReply.newBuilder().addAllItems(messages.items.map { m ->
            Message.newBuilder()
                .setId(m.id)
                .setMessageText(m.messageText)
                .setReceivedAt(Timestamps.fromNanos(m.receivedAt.nano.toLong()))
                .setReplicatedAt(Timestamps.fromNanos(m.replicatedAt.nano.toLong()))
                .build()
        }).build()
    }
}