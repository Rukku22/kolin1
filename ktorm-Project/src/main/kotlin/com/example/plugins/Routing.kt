package com.example.plugins

import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import model.EmployeeDTO
import service.EmployeeService

fun Application.configureRouting() {
    val service= EmployeeService()

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get ("/save1"){
            val insert=call.receive<EmployeeDTO>()

            var noofrows=service.saveEmp(insert)
            if(noofrows>0){
                println(insert)
                call.respond("successfully save")
            }else{
                call.respond("somthing went wrong...")
            }


        }
        get ("/getdata"){
            call.respond(service.getdata())

        }
        get ("/update"){
            call.respond(service.update())
        }
        get("/delete"){
            call.respond(service.delete())

        }
    }
}
