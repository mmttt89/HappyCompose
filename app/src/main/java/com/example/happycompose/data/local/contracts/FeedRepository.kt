package com.example.happycompose.data.local.contracts

import com.example.happycompose.data.models.Post
import com.example.happycompose.data.models.SingleStoryItem
import kotlinx.coroutines.flow.MutableSharedFlow

interface FeedRepository {
    val stories: MutableSharedFlow<List<SingleStoryItem>>
    val feeds: MutableSharedFlow<List<Post>>

    fun getStories()
    fun getFeeds()

    fun cancel()
}