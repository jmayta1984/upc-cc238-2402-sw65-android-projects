package pe.edu.upc.presentation.sign_in

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier

@Composable
fun SignInScreen(viewModel: SignInViewModel) {
    val state = viewModel.state.value

    val username = viewModel.username.value

    val password = viewModel.password.value

    Scaffold { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding))
        {
            OutlinedTextField(
                value = username,
                onValueChange = { viewModel.onUsernameChanged(it) }
            )
            OutlinedTextField(
                value = password,
                onValueChange = { viewModel.onPasswordChanged(it) }
            )
            OutlinedButton(onClick = {
                viewModel.signIn()
            }) {
                Text("Sign In")
            }
            state.user?.let {
                Text("Welcome ${it.username}")
            }
            if (state.error.isNotEmpty()) {
                Text(state.error)
            }
            if (state.isLoading) {
                CircularProgressIndicator()
            }
        }
    }
}