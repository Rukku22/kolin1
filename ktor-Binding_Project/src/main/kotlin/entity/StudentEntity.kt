package entity


import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object StudentEntity : Table<Nothing>("student") {
    val reg_no=int("reg_no").primaryKey()
    val name=varchar("name")
    var email=varchar("email")
    var place=varchar("place")
    var mobile_no=int("mobile_no")
    val dept_id=int("dept_id")

}