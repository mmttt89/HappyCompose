package com.example.happycompose.data.dto

import com.example.happycompose.data.models.Post

data class FeedResponse(
    val feeds: List<Post>,
    val status: String,
    val totalResults: Int,
    val page: Int
)
