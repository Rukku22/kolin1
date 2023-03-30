package com.example.plugins

import com.example.plugins.Customer
import com.example.plugins.CustomerCredinals
import com.example.plugins.DataBaseConnection
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import me.liuwj.ktorm.dsl.from
import me.liuwj.ktorm.dsl.insert
import me.liuwj.ktorm.dsl.map
import me.liuwj.ktorm.dsl.select
import transaction.DummyException

fun Application.configureRouting() {

        val db = DataBaseConnection.database
        routing {
            get("/") {
                call.respond("Hello World!")
            }


        get("/insert") {
            val details = call.receive<CustomerCredinals>()
            val id = details.id
            val name = details.name
            val email = details.email
            val place = details.place

            println(details.email)

            db.insert(Customer) {
                set(it.id, id)
                set(it.name, name)
                set(it.email, email)
                set(it.place, place)
            }
            call.respond("Succesfully inserted")
        }
        get("/read") {

            var data=db.from(Customer).select().map {row ->Customer.createEntity(row) }
            call.respond(data)

        }

    }
}