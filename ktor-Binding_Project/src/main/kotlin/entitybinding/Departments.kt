package entitybinding

import Interface.Department

import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object Departments: Table<Department>("department"){//interface
    val dept_id=int("dept_id").primaryKey().bindTo { it.dept_id }
    var dept_name=varchar("dept_name").bindTo { it.dept_name }
    var dept_location=varchar("dept_location").bindTo { it.dept_location }
}