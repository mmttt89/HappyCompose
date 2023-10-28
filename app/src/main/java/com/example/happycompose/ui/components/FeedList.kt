package com.example.happycompose.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.happycompose.data.models.Post

@Composable
fun FeedList(posts: List<Post>) {

    LazyColumn(
        content = {
            items(posts) { storyItem ->
                Text(text = "HERE")
                Spacer(modifier = Modifier.width(8.dp))
            }
        },
        contentPadding = PaddingValues(all = 8.dp)
    )
}