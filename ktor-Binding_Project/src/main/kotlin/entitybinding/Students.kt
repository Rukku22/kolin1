package entitybinding

import Interface.Student1
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object Students : Table<Student1>("student") {
   val reg_no=int("reg_no").primaryKey().bindTo { it.reg_no }
    val name=varchar("name").bindTo { it.name }
    var email=varchar("email").bindTo { it.email }
    var place=varchar("place").bindTo { it.place }
    var mobile_no=int("mobile_no").bindTo { it.mobile_no }
    var dept_id=int("dept_id").references(Departments){it.dept_id}
}