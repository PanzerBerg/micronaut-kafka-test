package com.example.kafka

import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.OffsetReset
import io.micronaut.configuration.kafka.annotation.Topic
import org.slf4j.LoggerFactory

@KafkaListener(
    offsetReset = OffsetReset.EARLIEST,
    threads = 5
)
@Suppress("unused")
class KafkaListener {

    private val logger = LoggerFactory.getLogger(KafkaListener::class.java)

    @Topic("send-email")
    fun receive(@KafkaKey id: String?, email: String, partition: Int) {
        logger.info("Recebendo mensagem. Email: $email")
    }
}