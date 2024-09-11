package pe.edu.upc.data.remote

import com.google.gson.annotations.SerializedName
import pe.edu.upc.domain.model.User

data class UserDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String
)

fun UserDto.toUser() = User(
    username = username
)
