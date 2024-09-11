package pe.edu.upc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import pe.edu.upc.common.Constants
import pe.edu.upc.data.remote.AuthService
import pe.edu.upc.data.repository.AuthRepository
import pe.edu.upc.presentation.sign_in.SignInScreen
import pe.edu.upc.presentation.sign_in.SignInViewModel
import pe.edu.upc.ui.theme.AuthComposeTheme
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    private val service = Retrofit.Builder().baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build().create(AuthService::class.java)
    private val viewModel = SignInViewModel(AuthRepository(service))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AuthComposeTheme {
                SignInScreen(viewModel)
            }
        }
    }
}

