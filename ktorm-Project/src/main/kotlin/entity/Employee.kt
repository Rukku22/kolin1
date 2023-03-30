package entity

 import entity.Employee.bindTo
 import org.ktorm.entity.Entity
 import org.ktorm.schema.Table
 import org.ktorm.schema.int
 import org.ktorm.schema.long
 import org.ktorm.schema.varchar
interface Employeee: Entity<Employeee> {
    val emp_id:Int
    var emp_name:String
    var emp_email:String
}




object Employee: Table<Employeee>("employees") {
    val emp_id = int("emp_id").primaryKey().bindTo { it.emp_id }
    val emp_name = varchar("emp_name").bindTo { it.emp_name }
    val emp_email = varchar("emp_email").bindTo { it.emp_email }
  }
