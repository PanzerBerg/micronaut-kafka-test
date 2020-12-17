package com.example.repositories

import com.example.model.Cliente
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface ClienteRepository : CrudRepository<Cliente, String> {

}