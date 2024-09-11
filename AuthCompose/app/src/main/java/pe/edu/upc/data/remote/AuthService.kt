package pe.edu.upc.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AuthService {
    @GET("users")
    suspend fun signIn(
        @Query("username") username: String,
        @Query("password") password: String
    ): Response<List<UserDto>>
}