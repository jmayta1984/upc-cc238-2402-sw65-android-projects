package pe.edu.upc.logincompose.feature_auth.domain.repository

interface LoginRepository {

    fun signIn(username: String, password: String)

    fun signUp(username: String, password: String)

}