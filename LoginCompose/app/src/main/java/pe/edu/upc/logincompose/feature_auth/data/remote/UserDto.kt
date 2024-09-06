package pe.edu.upc.logincompose.feature_auth.data.remote

import com.google.gson.annotations.SerializedName
import pe.edu.upc.logincompose.feature_auth.domain.model.User

data class UserDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String
)

fun UserDto.toUser(): User {
    return User(username = username)
}