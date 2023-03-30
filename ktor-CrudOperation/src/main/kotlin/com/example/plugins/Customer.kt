package com.example.plugins


import me.liuwj.ktorm.schema.Table
import me.liuwj.ktorm.schema.int
import me.liuwj.ktorm.schema.varchar

object Customer: Table<Nothing>("tech") {
     val id = int("id").primaryKey()
    val name = varchar("name")
    val email = varchar("email")
    val place = varchar("place")
}