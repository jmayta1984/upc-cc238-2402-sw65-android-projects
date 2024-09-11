package pe.edu.upc.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.upc.data.remote.AuthService
import pe.edu.upc.common.Resource
import pe.edu.upc.data.remote.toUser
import pe.edu.upc.domain.model.User

class AuthRepository(private val authService: AuthService) {

    suspend fun signIn(username: String, password: String): Resource<User> =
        withContext(Dispatchers.IO) {
            val response = authService.signIn(username, password)
            if (response.isSuccessful) {
                val user = response.body()?.firstOrNull()?.toUser()
                if (user != null) {
                    return@withContext Resource.Success(user)
                }
                return@withContext Resource.Error("User not found")
            }
            return@withContext Resource.Error(response.message())

        }

}