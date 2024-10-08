package pe.edu.upc.logincompose.core

sealed class Resource<T>(val data: T? = null, val message: String = "") {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
    class Loading<T>(data: T? = null) : Resource<T>(data)
}