package entity


import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object DepartmentEntity:Table<Nothing>("department"){
    val dept_id=int("dept_id").primaryKey()
    var dept_name=varchar("dept_name")
    var dept_location=varchar("dept_location")

}