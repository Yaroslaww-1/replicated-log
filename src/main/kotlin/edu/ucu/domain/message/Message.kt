package edu.ucu.domain.message

import java.time.LocalDateTime

class Message {
    private val id: Long
    private val messageText: String
    private val createdAt: LocalDateTime

    fun id() = id
    fun messageText() = messageText
    fun createdAt() = createdAt

    private constructor(
        id: Long,
        messageText: String,
        createdAt: LocalDateTime,
    ) {
        this.id = id
        this.messageText = messageText
        this.createdAt = createdAt
    }

    companion object {
        fun create(id: Long, messageText: String, createdAt: LocalDateTime): Message {
            return Message(id, messageText, createdAt)
        }
    }
}