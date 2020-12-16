package com.example.model

import com.sun.istack.NotNull
import org.hibernate.annotations.GenericGenerator
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.Email

@Entity
@Suppress("unused")
open class Cliente(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    open val id: String,
    @field:NotNull
    open val nome: String,
    @field:NotNull
    @field:Email
    open val email: String
)