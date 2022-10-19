package edu.ucu.api.controllers.message

import ReplicatedLogGrcp.MessageOuterClass.*
import ReplicatedLogGrcp.MessageReplicationGrpcKt
import com.google.protobuf.Empty
import com.google.protobuf.util.Timestamps
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
): MessageReplicationGrpcKt.MessageReplicationCoroutineImplBase() {
    override suspend fun appendMessage(request: AppendMessageRequest): AppendMessageReply {
        createMessageCommandHandler.execute(CreateMessageCommand(
            request.id,
            request.messageText,
            LocalDateTime.ofEpochSecond(request.createdAt.seconds, request.createdAt.nanos, ZoneOffset.UTC)
        ))
        return AppendMessageReply.newBuilder()
            .setSuccess(true)
            .setResponseText("Replicated successfully")
            .build()
    }

    override suspend fun getAllMessages(request: Empty): GetAllMessagesReply {
        val messages = getAllMessagesQueryHandler.execute(GetAllMessagesQuery())
        return GetAllMessagesReply.newBuilder()
            .addAllItems(messages.items.map { m ->
                Message.newBuilder()
                    .setId(m.id)
                    .setMessageText(m.messageText)
                    .setCreatedAt(Timestamps.fromNanos(m.createdAt.nano.toLong()))
                    .build()
            })
            .setSuccess(true)
            .setResponseText("Replicated messages")
            .build()
    }
}