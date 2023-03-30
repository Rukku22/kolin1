package model

import kotlinx.serialization.Serializable

@Serializable
data class Extradata(
    var epicure_type:String,
    var domicile:String,
    var state:String,
    var country_code:String
)