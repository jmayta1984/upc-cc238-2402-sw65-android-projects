package pe.edu.upc.logincompose.feature_auth.domain.repository
import pe.edu.upc.logincompose.feature_auth.data.remote.UserDto


interface LoginRepository {

    fun signIn(username: String, password: String, callback: (List<UserDto>) -> Unit)

    fun signUp(username: String, password: String)

}