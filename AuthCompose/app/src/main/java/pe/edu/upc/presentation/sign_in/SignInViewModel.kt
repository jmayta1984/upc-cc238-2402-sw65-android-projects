package pe.edu.upc.presentation.sign_in

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pe.edu.upc.common.Resource
import pe.edu.upc.data.repository.AuthRepository

class SignInViewModel(private val authRepository: AuthRepository):ViewModel() {

    private val _state = mutableStateOf(SignInState())
    val state: State<SignInState> get() = _state

    private val _username = mutableStateOf("")
    val username: State<String> get() = _username

    private val _password = mutableStateOf("")
    val password: State<String> get() = _password

    fun signIn() {
        _state.value = SignInState(isLoading = true)
        viewModelScope.launch {
            val result = authRepository.signIn(_username.value, _password.value)
            if (result is Resource.Success) {
                _state.value = SignInState(user = result.data)
            } else {
                _state.value = SignInState(error =result.message?:"Error")
            }
        }
    }

    fun onUsernameChanged(username: String) {
        _username.value = username
    }

    fun onPasswordChanged(password: String) {
        _password.value = password
    }
}