package com.example.happycompose.ui.feature.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.happycompose.data.local.contracts.FeedRepository
import com.example.happycompose.data.models.Post
import com.example.happycompose.data.models.SingleStoryItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(private val feedRepository: FeedRepository) : ViewModel() {
    private val coroutineScope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    private val _storiesLiveData = MutableLiveData<List<SingleStoryItem>>()
    val stories: LiveData<List<SingleStoryItem>> = _storiesLiveData

    private val _feedsLiveData = MutableLiveData<List<Post>>()
    val feeds: LiveData<List<Post>> = _feedsLiveData

    init {
        feedRepository.getStories()
        dataListeners()
    }

    fun getFeedsPaging(): Flow<PagingData<Post>> = feedRepository.getFeedPaging().cachedIn(viewModelScope)

    private fun dataListeners() {
        // update stories
        coroutineScope.launch {
            feedRepository.stories.collect {
                _storiesLiveData.postValue(it)
            }
        }
        // update feeds
        coroutineScope.launch {
            feedRepository.feeds.collect {
                _feedsLiveData.postValue(it)
            }
        }
    }
}