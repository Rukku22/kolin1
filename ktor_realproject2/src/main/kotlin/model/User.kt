package model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    var first_name:String,
    var last_name:String,
    var email:String,




)
