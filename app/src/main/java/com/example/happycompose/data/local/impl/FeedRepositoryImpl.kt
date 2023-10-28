package com.example.happycompose.data.local.impl

import android.util.Log
import com.example.happycompose.data.local.contracts.FeedRepository
import com.example.happycompose.data.models.Post
import com.example.happycompose.data.models.SingleStoryItem
import com.example.happycompose.data.remote.contracts.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class FeedRepositoryImpl @Inject constructor(private val apiService: ApiService) : FeedRepository {
    private val coroutineScope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    override val stories: MutableSharedFlow<List<SingleStoryItem>> =
        MutableSharedFlow(extraBufferCapacity = 24)
    override val feeds: MutableSharedFlow<List<Post>> = MutableSharedFlow(extraBufferCapacity = 24)

    override fun getStories() {
        coroutineScope.launch {
            try {
                val result = apiService.getStories()
                if (result.isSuccessful) {
                    result.body()?.let {
                        if (it.isNotEmpty()) {
                            stories.emit(it)
                        } else {
                            throw Exception("sorry it is empty")
                        }
                    }
                } else {
                    Log.d("SomeLog", "no result")
                }
            } catch (e: Exception) {
                Log.d("SomeLog", e.message.toString())
            }
        }
    }

    override fun cancel() {
        coroutineScope.cancel()
    }

    override fun getFeeds() {
        coroutineScope.launch {
            try {
                val result = apiService.getFeeds()
                if (result.isSuccessful) {
                    result.body().let {
                        if (!it.isNullOrEmpty()) {
                            feeds.emit(it)
                        } else {
                            throw Exception("sorry it is empty")
                        }
                    }
                } else {

                }
            } catch (e: Exception) {

            }
        }
    }
}