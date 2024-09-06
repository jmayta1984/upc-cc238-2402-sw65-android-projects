package pe.edu.upc.logincompose.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import pe.edu.upc.logincompose.core.ui.theme.LoginComposeTheme
import pe.edu.upc.logincompose.feature_auth.data.remote.LoginService
import pe.edu.upc.logincompose.feature_auth.data.repository.LoginRepositoryImpl
import pe.edu.upc.logincompose.feature_auth.domain.use_case.SignInUseCase
import pe.edu.upc.logincompose.feature_auth.presentation.sign_in.SignInScreen
import pe.edu.upc.logincompose.feature_auth.presentation.sign_in.SignInViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {

    private val service: LoginService = Retrofit
        .Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(LoginService::class.java)
    private val repository = LoginRepositoryImpl(service)
    private val useCase = SignInUseCase(repository)
    private val viewModel = SignInViewModel(useCase)
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
