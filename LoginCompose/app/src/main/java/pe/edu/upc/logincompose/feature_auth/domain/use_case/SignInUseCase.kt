package pe.edu.upc.logincompose.feature_auth.domain.use_case

import pe.edu.upc.logincompose.core.Resource
import pe.edu.upc.logincompose.feature_auth.data.remote.UserDto
import pe.edu.upc.logincompose.feature_auth.data.remote.toUser
import pe.edu.upc.logincompose.feature_auth.domain.model.User
import pe.edu.upc.logincompose.feature_auth.domain.repository.LoginRepository

class SignInUseCase(private val loginRepository: LoginRepository) {

    operator fun invoke(username: String, password: String, callback: (Resource<User>) -> Unit) {
        callback(Resource.Loading())
        loginRepository.signIn(username, password) { usersDto: List<UserDto> ->
            if (usersDto.isEmpty()) {
                callback(Resource.Error(message = "User not found"))
            } else {
                callback(Resource.Success(data = usersDto[0].toUser()))
            }
        }

    }
}