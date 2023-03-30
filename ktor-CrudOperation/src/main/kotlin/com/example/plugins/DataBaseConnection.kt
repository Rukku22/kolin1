package com.example.plugins

import me.liuwj.ktorm.database.Database

object DataBaseConnection{
    val Driver= "com.mysql.cj.jdbc.Driver"
    val url ="jdbc:mysql://localhost:3306/ihcl"
    val userid ="root"
    val pass="root"
    val database = Database.connect(url,Driver,userid,pass)
}