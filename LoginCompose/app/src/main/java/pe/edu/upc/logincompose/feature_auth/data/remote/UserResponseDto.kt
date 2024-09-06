package pe.edu.upc.logincompose.feature_auth.data.remote

import com.google.gson.annotations.SerializedName

class UserResponseDto (

    @SerializedName("id")
    val  id: Int,

    @SerializedName("username")
    val username: String,

    @SerializedName("password")
    val password: String,

    @SerializedName("first_name")
    val firstName: String,

    @SerializedName("last_name")
    val lastName: String
)