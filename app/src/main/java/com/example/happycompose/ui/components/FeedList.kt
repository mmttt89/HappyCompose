package com.example.happycompose.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.happycompose.data.models.Post
import com.example.happycompose.ui.components.post.PostItem

@Composable
fun FeedList(posts: List<Post>) {
    LazyColumn(
        content = {
            items(posts) { post ->
                PostItem(post)
                Spacer(modifier = Modifier.height(20.dp))
            }
        },
    )
}