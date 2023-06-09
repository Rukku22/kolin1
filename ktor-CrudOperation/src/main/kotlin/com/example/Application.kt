package com.example

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import io.ktor.serialization.gson.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*

fun main() {
    embeddedServer(Netty, port = 8081, host = "0.0.0.0") {
        install(ContentNegotiation){
            gson()
        }
         
        trans()
     }.start(wait = true)
}