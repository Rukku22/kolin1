package com.example.plugins

import Interface.Student1
import entitybinding.Departments
import entitybinding.Students
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import model.Department
import model.Student
import repository.SubRepository

fun Application.configureRouting() {
    val totaldetails = SubRepository()
     routing {
        get ("/save"){
            val data=call.receive<Student>()
            var insert= totaldetails.saveStudent(data)
            call.respond("success")

        }
        get ("/savedept"){
            val v=call.receive<Department>()
             var v1=totaldetails.saveDepartment(v)
            call.respond("sucess")
         }
        get("/getstudent") {
            val customersgetting = totaldetails.getStudent()
            call.respond(customersgetting)
         }
        get("/getdept") {
            val vehiclegetting = totaldetails.getDept()
            call.respond(vehiclegetting)

        }
        get("/getstudentid"){
            val customerid = totaldetails.getStudentById(reg_no =Students.reg_no)
        call.respond(customerid)
        }
        get ("/getdeptid"){
            val vehicleids = totaldetails.getDeptById(dept_id =Departments.dept_id)
            call.respond(vehicleids)
          }

    }
}
