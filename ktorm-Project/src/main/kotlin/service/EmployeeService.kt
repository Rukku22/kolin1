package service

import model.EmployeeDTO
import repository.EmployeeRepository

class EmployeeService
{
private  val repository=EmployeeRepository()
    suspend fun saveEmp(params:EmployeeDTO): Int {
        val num= repository.saveEmp(params)
         println(num)
        return num
    }
    suspend fun getdata():List<EmployeeDTO>{
        var data=repository.getEmployee()
        println(data)
        return data
    }
    suspend fun update():Int{
        var update=repository.update()
        println(update)
        return  update
    }
   suspend fun delete(){
       val delete=repository.delete()
       println(delete)

   }
}