package com.example.controllers

import com.example.ClienteReply
import com.example.ClienteRequest
import com.example.ClienteServiceGrpc
import com.example.kafka.KafkaClient
import com.example.model.Cliente
import com.example.repositories.ClienteRepository
import io.grpc.stub.StreamObserver
import io.micronaut.validation.Validated
import org.slf4j.LoggerFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Suppress("unused")
open class ClienteController(
    open var repository : ClienteRepository,
    open var kafkaClient: KafkaClient
) : ClienteServiceGrpc.ClienteServiceImplBase() {

    private val logger = LoggerFactory.getLogger(ClienteController::class.java)

    @Validated
    override fun criarCliente(request: ClienteRequest, responseObserver: StreamObserver<ClienteReply>) {
        logger.info("Entrando em CriarCliente()")

        val cliente = Cliente(nome = request.nome, email = request.email)
        logger.info("Novo cliente criado")

        repository.save(cliente)
        logger.info("Cliente salvo no banco de dados")

        logger.info("Enviando cliente por Kafka. Topico: 'send-email'")
        kafkaClient.sendEmail(cliente.id, cliente.email)
        logger.info("Cliente enviado por Kafka. Topico: 'send-email'")

        responseObserver.onNext(ClienteReply.newBuilder().setId(cliente.id).build())
        responseObserver.onCompleted()
    }

}