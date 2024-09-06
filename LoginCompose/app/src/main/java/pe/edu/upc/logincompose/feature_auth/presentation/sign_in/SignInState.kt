package pe.edu.upc.logincompose.feature_auth.presentation.sign_in

import pe.edu.upc.logincompose.feature_auth.domain.model.User

data class SignInState(
    val isLoading: Boolean = false,
    val user: User? = null,
    val error: String = ""
)
