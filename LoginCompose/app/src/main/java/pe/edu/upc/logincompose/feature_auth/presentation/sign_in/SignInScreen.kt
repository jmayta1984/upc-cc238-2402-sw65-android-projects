package pe.edu.upc.logincompose.feature_auth.presentation.sign_in

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState

import androidx.compose.ui.Modifier

@Composable
fun SignInScreen(viewModel: SignInViewModel) {

    val state = viewModel.state.collectAsState().value

    Scaffold { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            OutlinedTextField(value = viewModel.username.collectAsState().value, onValueChange = {
                viewModel.onUsernameChanged(it)
            })
            OutlinedTextField(value = viewModel.password.collectAsState().value, onValueChange = {
                viewModel.onPasswordChanged(it)
            })
            OutlinedButton(onClick = {
                viewModel.signIn()
            }) {
                Text("Sign in")
            }
            state.user?.let {
                Text(it.username)
            }
            if (state.isLoading){
                CircularProgressIndicator()
            }
            if (state.error.isNotBlank()){
                Text(state.error)
            }
        }
    }


}