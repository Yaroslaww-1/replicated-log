package edu.ucu.infrastructure.inmemory

import edu.ucu.application.message.MessageRepository
import edu.ucu.domain.message.Message
import jakarta.inject.Singleton

@Singleton
class MessageRepositoryImpl : MessageRepository {
    private val messages: MutableList<Message> = mutableListOf()

    override fun add(message: Message): Unit {
        messages.add(message)
    }

    override fun getAll(): List<Message> {
        return messages.toList()
    }
}