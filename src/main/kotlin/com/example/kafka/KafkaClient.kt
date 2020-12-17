package com.example.kafka

import com.google.j2objc.annotations.Property
import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.Topic
import org.apache.kafka.clients.producer.ProducerConfig
import javax.validation.constraints.Email

@KafkaClient(

)
interface KafkaClient {

    @Topic("send-email")
    fun sendEmail(@KafkaKey id: String?, email: String);
}