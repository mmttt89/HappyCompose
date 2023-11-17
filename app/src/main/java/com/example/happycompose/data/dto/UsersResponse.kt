package com.example.happycompose.data.dto

import com.example.happycompose.data.models.User
import retrofit2.Response

data class UsersResponse(
    val users: List<User>,
    val status: String,
    val totalResults: Int,
    val page: Int
)
