package com.example

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int


interface Customers : Entity<Customers> {
    var reg_no:Int
    var name: String
 }

object CustomerEntity : Table<Customers>("customernew") {
    val reg_no=int("reg_no").primaryKey().bindTo { it.reg_no}
 }
