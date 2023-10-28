package com.example.happycompose.ui.feature.feed

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.happycompose.ui.components.FeedList
import com.example.happycompose.ui.components.MainHeader
import com.example.happycompose.ui.components.StoriesList
import com.example.happycompose.ui.theme.HappyComposeTheme

@Composable
fun MainPage() {
    val feedViewModel = viewModel<FeedViewModel>()
    val stories by feedViewModel.stories.observeAsState(emptyList())
    val posts by feedViewModel.feeds.observeAsState(emptyList())

    HappyComposeTheme {
        // A surface container using the 'background' color from the theme
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
        MainPage()
    }
}