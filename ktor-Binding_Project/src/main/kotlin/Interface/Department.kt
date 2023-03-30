package Interface

import org.ktorm.entity.Entity

interface Department:Entity<Department> {
    val dept_id: Int
    var dept_name: String
    var  dept_location: String
}