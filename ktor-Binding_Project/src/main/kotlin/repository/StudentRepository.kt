package repository

import Interface.Student1
import databaseconfig.Databasefactory
import entitybinding.Departments
import entitybinding.Students
import model.Department
import model.Student
import org.ktorm.dsl.*
import org.ktorm.schema.Column

interface StudentRepository {
    fun saveStudent(params: Student)
    fun saveDepartment(params: Department)
    fun getStudent(): List<Student1>
    fun getStudentById(reg_no: Column<Int>): List<Student1>
    fun getDept(): List<Interface.Department>
    fun getDeptById(dept_id: Column<Int>): List<Interface.Department>

}

class SubRepository : StudentRepository {
    val db = Databasefactory.getConnection()
    override fun saveStudent(params: Student) {
        db.insert(Students) {
            set(it.reg_no, params.reg_no)
            set(it.name, params.name)
            set(it.email, params.email)
            set(it.place, params.place)
            set(it.mobile_no, params.mobile_no)
            set(it.dept_id, params.dept_id)
        }

    }

    override fun saveDepartment(params: Department) {
        db.insert(Departments) {
            set(it.dept_id, params.dept_id)
            set(it.dept_name, params.dept_name)
            set(it.dept_location, params.dept_location)
        }
    }


    override fun getStudent(): List<Student1> {
        return db.from(Students).select().map { row -> Students.createEntity(row) }
    }

    override fun getStudentById(reg_no: Column<Int>): List<Student1> {
     return   db.from(Students).joinReferencesAndSelect().map { row -> Students.createEntity(row) }
    }

    override fun getDept(): List<Interface.Department> {
        return db.from(Departments).select().map { row -> Departments.createEntity(row) }
    }

    override fun getDeptById(dept_id: Column<Int>): List<Interface.Department> {
        return db.from(Departments).joinReferencesAndSelect().map { row ->Departments.createEntity(row)  }
    }

}


