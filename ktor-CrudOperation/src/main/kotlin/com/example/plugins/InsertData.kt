package com.example.plugins

import com.example.plugins.DataBaseConnection.database
 import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import me.liuwj.ktorm.dsl.insert
import java.io.File
import java.sql.DriverManager.println

fun Application.InsertData() {
    val db=DataBaseConnection.database
    routing {
        get("/hello") {
             val cusdetails = call.receive<CustomerCredinals>()
            val id = cusdetails.id
            val name = cusdetails.name
            val email=   cusdetails.email
            val place=cusdetails.place
            println("$id $name $email $place")
            db.insert(Customer){
                set(it.id,id)
                set(it.name,name)
                set(it.email,email)
                set(it.place,place)
              }
            call.respond("Success")
        }

    }
}