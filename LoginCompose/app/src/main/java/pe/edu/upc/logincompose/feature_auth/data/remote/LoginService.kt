package pe.edu.upc.logincompose.feature_auth.data.remote

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LoginService {

    @GET("users")
    fun signIn(
        @Query("username")
        username: String,
        @Query("password")
        password: String): Call<List<UserDto>>


    @POST("users")
    fun signUp(
        @Body request: UserRequestDto
    ): Call<UserResponseDto>
}