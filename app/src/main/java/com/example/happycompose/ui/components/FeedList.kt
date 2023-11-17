package com.example.happycompose.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemsIndexed
import com.example.happycompose.data.models.Post
import com.example.happycompose.ui.components.post.PostItem

@Composable
fun FeedList(posts: LazyPagingItems<Post>) {
    LazyColumn {
        itemsIndexed(
            items = posts,
            key = { _, post -> "${post.id}+${post.user}" }
        ) { _, post ->
            post?.let {
                PostItem(post)
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}