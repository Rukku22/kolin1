package repository

import dpconfig.DatabaseConfig
import dpconfig.DatabaseConfig.database
import entity.Employee
 import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import model.EmployeeDTO
import org.ktorm.dsl.*

class EmployeeRepository {
    val db = DatabaseConfig.database

    suspend fun saveEmp(params: EmployeeDTO): Int {
        val noorrows: Int
        noorrows = db.insert(Employee) {
            set(it.emp_id, params.emp_id)
            set(it.emp_name, params.emp_name)
            set(it.emp_email, params.emp_email)
         }
        return noorrows
    }

    suspend fun getEmployee():List<EmployeeDTO> {
        return db.from(Employee).select().map { row -> Employee.createEntity(row) }.map { EmployeeDTO(
            it.emp_id,
            it.emp_name,
            it.emp_email

        ) }
    }

    suspend fun update(): Int {
        return db.update(Employee) {
            set(it.emp_id, 1234)
            set(it.emp_name, "sravani")
            set(it.emp_email, "sha@123")

        }
    }
    suspend fun delete(){
        db.delete(Employee){it.emp_id eq 1}
     }

    }





