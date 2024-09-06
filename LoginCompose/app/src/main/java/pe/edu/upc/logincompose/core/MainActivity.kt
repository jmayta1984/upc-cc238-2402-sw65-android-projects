package pe.edu.upc.logincompose.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.upc.logincompose.core.ui.theme.LoginComposeTheme
import pe.edu.upc.logincompose.feature_auth.presentation.sign_in.SignInScreen
import pe.edu.upc.logincompose.feature_auth.presentation.sign_in.SignInViewModel

class MainActivity : ComponentActivity() {

    private val viewModel = SignInViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginComposeTheme {
               SignInScreen(viewModel)
            }
        }
    }
}
