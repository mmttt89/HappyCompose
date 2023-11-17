package com.example.happycompose.data.remote

sealed class NetworkResult<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : NetworkResult<T>(data = data)
    class Error<T>(val code: Int, message: String) : NetworkResult<T>(message = message)
    class Loading<T> : NetworkResult<T>()
}