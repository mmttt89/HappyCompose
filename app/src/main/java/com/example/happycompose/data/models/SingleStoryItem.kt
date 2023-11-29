package com.example.happycompose.data.models

data class SingleStoryItem(
    val id: String? = null,
    val title: String? = null,
    val user: User? = null,
    val medias: List<Media>,
    val isLive: Boolean? = false
)
