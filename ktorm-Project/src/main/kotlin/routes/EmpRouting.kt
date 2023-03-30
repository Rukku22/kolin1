package routes

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import model.EmployeeDTO
import service.EmployeeService

fun Application.EmpConfig(){
     routing {
        route("api/v1/emp"){

        }
    }
}