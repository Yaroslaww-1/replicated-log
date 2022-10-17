package edu.ucu.application.message

import edu.ucu.domain.message.Message

interface MessageRepository {
    fun add(message: Message): Unit
    fun getAll(): List<Message>
}