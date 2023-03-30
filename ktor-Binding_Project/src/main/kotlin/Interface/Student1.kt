package Interface

 import org.ktorm.entity.Entity

interface Student1 :Entity<Student1>{
    val reg_no: Int
    var name: String
    var email: String
    var place: String
    var mobile_no: Int
    var dept_id:Department
 }