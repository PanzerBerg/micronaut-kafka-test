package com.example.kafka

import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.Topic
import javax.validation.constraints.Email

@KafkaClient
interface KafkaClient {

    @Topic("send-email")
    fun sendEmail(@KafkaKey id: String, email: String);
}