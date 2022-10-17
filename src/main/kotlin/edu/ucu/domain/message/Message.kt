package edu.ucu.domain.message

import java.time.LocalDateTime

class Message {
    private val id: Long
    private val messageText: String
    private val receivedAt: LocalDateTime
    private val replicatedAt: LocalDateTime

    fun id() = id
    fun messageText() = messageText
    fun receivedAt() = receivedAt
    fun replicatedAt() = replicatedAt

    private constructor(
        id: Long,
        messageText: String,
        receivedAt: LocalDateTime,
        replicatedAt: LocalDateTime
    ) {
        this.id = id
        this.messageText = messageText
        this.receivedAt = receivedAt
        this.replicatedAt = replicatedAt
    }

    companion object {
        fun create(id: Long, messageText: String, receivedAt: LocalDateTime): Message {
            return Message(id, messageText, receivedAt, LocalDateTime.now())
        }
    }
}