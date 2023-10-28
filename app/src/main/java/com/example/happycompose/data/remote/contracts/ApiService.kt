package com.example.happycompose.data.remote.contracts

import com.example.happycompose.data.models.Post
import com.example.happycompose.data.models.SingleStoryItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("stories")
    suspend fun getStories(): Response<List<SingleStoryItem>>

    @GET("feeds")
    suspend fun getFeeds(): Response<List<Post>>
}