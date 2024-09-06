package pe.edu.upc.logincompose.feature_auth.presentation.sign_in

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import pe.edu.upc.logincompose.core.Resource
import pe.edu.upc.logincompose.feature_auth.domain.use_case.SignInUseCase

class SignInViewModel(private val signInUseCase: SignInUseCase): ViewModel() {
    fun onUsernameChanged(username: String) {
        _username.value = username
    }

    fun onPasswordChanged(password: String) {
        _password.value = password
    }

    private val _username = MutableStateFlow("")
    val username: StateFlow<String> get() = _username

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> get() = _password

    private val _state = MutableStateFlow(SignInState())
    val state: StateFlow<SignInState> get() = _state

    fun signIn() {
        signInUseCase.invoke(_username.value, _password.value) { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = SignInState(user = result.data)
                }
                is Resource.Loading -> {
                    _state.value = SignInState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = SignInState(error = result.message)
                }
            }
        }
    }
}