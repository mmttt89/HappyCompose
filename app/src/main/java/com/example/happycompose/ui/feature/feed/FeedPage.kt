package com.example.happycompose.ui.feature.feed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.happycompose.ui.components.FeedList
import com.example.happycompose.ui.components.MainHeader
import com.example.happycompose.ui.components.story.StoriesList
import com.example.happycompose.ui.theme.HappyComposeTheme


@Composable
fun HomePage() {
    val feedViewModel = hiltViewModel<FeedViewModel>()
    val stories by feedViewModel.stories.observeAsState(emptyList())
    val posts = feedViewModel.getFeedsPaging().collectAsLazyPagingItems()

    HappyComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                MainHeader()
                StoriesList(stories)
                FeedList(posts)
            }
        }
    }
}


@Composable
@Preview
fun MainPagePreview() {
    HappyComposeTheme {
        HomePage()
    }
}