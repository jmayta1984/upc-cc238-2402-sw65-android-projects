package pe.edu.upc.presentation.sign_in

import pe.edu.upc.domain.model.User

data class SignInState(
    val isLoading: Boolean = false,
    val user:  User? = null,
    val error: String = ""
)
