package model


data class Student(
    val reg_no:Int,
    var name:String,
    var email:String,
    var place: String,
    var mobile_no:  String,
    val dept_id:Department
)


