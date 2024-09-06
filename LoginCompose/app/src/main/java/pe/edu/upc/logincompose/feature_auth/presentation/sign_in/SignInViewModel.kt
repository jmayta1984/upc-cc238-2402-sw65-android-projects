package pe.edu.upc.logincompose.feature_auth.presentation.sign_in

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SignInViewModel: ViewModel() {
    fun onUsernameChanged(it: String) {

    }

    fun onPasswordChanged(it: String) {

    }

    private val _username = mutableStateOf("")
    val username: State<String> get() = _username

    private val _password = mutableStateOf("")
    val password: State<String> get() = _password
}