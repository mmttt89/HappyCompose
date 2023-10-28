package com.example.happycompose.data.models

data class Media(
    val id: String? = null,
    val type: MediaType = MediaType.Image,
    val url: String? = null,
)

enum class MediaType(val Value: Int) {
    Image(1),
    Video(2),
}