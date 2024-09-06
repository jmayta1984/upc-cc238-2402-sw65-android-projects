package pe.edu.upc.logincompose.feature_auth.domain.repository
import pe.edu.upc.logincompose.feature_auth.data.remote.UserDto
import pe.edu.upc.logincompose.feature_auth.data.remote.UserRequestDto
import pe.edu.upc.logincompose.feature_auth.data.remote.UserResponseDto


interface LoginRepository {

    fun signIn(username: String, password: String, callback: (List<UserDto>) -> Unit)

    fun signUp( userRequestDto: UserRequestDto, callback: (UserResponseDto) -> Unit )

}