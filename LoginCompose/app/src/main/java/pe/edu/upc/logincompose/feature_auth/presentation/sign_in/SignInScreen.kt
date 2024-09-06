package pe.edu.upc.logincompose.feature_auth.presentation.sign_in

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier

@Composable
fun SignInScreen(viewModel: SignInViewModel) {

    Scaffold { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            OutlinedTextField(value = viewModel.username.value, onValueChange = {
                viewModel.onUsernameChanged(it)
            })
            OutlinedTextField(value = viewModel.password.value, onValueChange = {
                viewModel.onPasswordChanged(it)
            })
            OutlinedButton(onClick = {

            }) {
                Text("Sign in")
            }
        }
    }


}