package pe.edu.upc.logincompose.feature_auth.data.repository

import pe.edu.upc.logincompose.feature_auth.data.remote.LoginService
import pe.edu.upc.logincompose.feature_auth.data.remote.UserDto
import pe.edu.upc.logincompose.feature_auth.data.remote.UserRequestDto
import pe.edu.upc.logincompose.feature_auth.data.remote.UserResponseDto
import pe.edu.upc.logincompose.feature_auth.domain.repository.LoginRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepositoryImpl(
    private val loginService: LoginService
) : LoginRepository {
    override fun signIn(username: String, password: String, callback: (List<UserDto>) -> Unit ) {
        loginService.signIn(username, password).enqueue(object : Callback<List<UserDto>> {
            override fun onResponse(call: Call<List<UserDto>>, response: Response<List<UserDto>>) {
                if (response.isSuccessful) {
                    callback(response.body()?: emptyList())
                }
            }

            override fun onFailure(call: Call<List<UserDto>>, response: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    override fun signUp(userRequestDto: UserRequestDto, callback: (UserResponseDto) -> Unit) {
        loginService.signUp(userRequestDto).enqueue(object: Callback<UserResponseDto> {
            override fun onResponse(call: Call<UserResponseDto>, response: Response<UserResponseDto>) {
                if (response.isSuccessful) {

                }
            }

            override fun onFailure(call: Call<UserResponseDto>, response: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }


}