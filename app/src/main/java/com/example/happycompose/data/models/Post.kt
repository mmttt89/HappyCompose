package com.example.happycompose.data.models

data class Post(
    val id: String,
    val user: User,
    val medias: List<Media>,
    val likesTotal: Int,
    val commentsTotal: Int,
    val viewsTotal: Int,
    val shareUrl: String,
)
