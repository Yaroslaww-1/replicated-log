package edu.ucu.application.message.create

import java.time.LocalDateTime

data class CreateMessageCommand(
    val id: Long,
    val messageText: String,
    val createdAt: LocalDateTime
) {}