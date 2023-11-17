package com.example.happycompose.data.local.contracts

import androidx.paging.PagingData
import com.example.happycompose.data.models.Post
import com.example.happycompose.data.models.SingleStoryItem
import com.example.happycompose.data.models.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

interface FeedRepository {
    val stories: MutableSharedFlow<List<SingleStoryItem>>
    val feeds: MutableSharedFlow<List<Post>>

    fun getStories()
    fun getFeedPaging(): Flow<PagingData<Post>>

    fun cancel()
}