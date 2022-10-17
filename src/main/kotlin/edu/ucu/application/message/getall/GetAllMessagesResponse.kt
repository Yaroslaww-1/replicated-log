package edu.ucu.application.message.getall

import java.time.LocalDateTime

data class GetAllMessagesResponse(val items: List<GetAllMessagesResponseItem>) {
    data class GetAllMessagesResponseItem(
        val id: Long,
        val messageText: String,
        val receivedAt: LocalDateTime,
        val replicatedAt: LocalDateTime,
    )
}