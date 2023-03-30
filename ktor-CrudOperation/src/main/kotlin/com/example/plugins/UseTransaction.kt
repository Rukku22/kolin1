package com.example.plugins

import com.example.plugins.DataBaseConnection.database
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import me.liuwj.ktorm.dsl.insert
import me.liuwj.ktorm.entity.count
import me.liuwj.ktorm.entity.sequenceOf
import transaction.DummyException

fun Application.trans() {
    routing {
        get("/trans") {

            try {
                database.useTransaction {
                    database.insert(Customer) {
                        set(it.id, 1987)
                        set(it.name, "ruksana")
                        set(it.email, "ruk@123")
                        set(it.place, "plmnr")
                    }
                    assert(database.sequenceOf(Customer).count() == 5)

                    throw DummyException("this is dummy exception")
                }
            } catch (e: DummyException) {
                assert(database.sequenceOf(Customer).count() == 4)
                call.respond("success")

            }
        }
    }
}