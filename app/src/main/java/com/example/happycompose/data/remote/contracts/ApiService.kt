package com.example.happycompose.data.remote.contracts

import com.example.happycompose.data.dto.FeedResponse
import com.example.happycompose.data.models.Post
import com.example.happycompose.data.models.SingleStoryItem
import com.example.happycompose.data.dto.UsersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("stories")
    suspend fun getStories(): Response<List<SingleStoryItem>>

    @GET("feeds")
    suspend fun getFeeds(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int,
    ): Response<FeedResponse>

    @GET("users")
    suspend fun getUsers(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int,
    ): Response<UsersResponse>
}