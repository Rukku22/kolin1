package model

import kotlinx.serialization.Serializable

@Serializable
data class UserAllDetails(
    var mobile:String,
    var gender:String,
    var salutation:String,
    var country:Int,
    var date_of_birth:String,
    var address_line1:String,
    var address_line2:String,
    var extra_data: Extradata,
    var user:User,
    var enrollment_touchpoint:Int,
    var enrollment_channel:String,
    var enrolling_sponsor:Int,
    var enrolling_location:String

)
