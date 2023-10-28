package com.example.happycompose.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.happycompose.data.SampleData
import com.example.happycompose.data.models.SingleStoryItem

@Composable
fun StoriesList(storyList: List<SingleStoryItem>) {

    LazyRow(
        content = {
            items(storyList) { storyItem ->
                StoryItem(storyItem = storyItem)
                Spacer(modifier = Modifier.width(8.dp))
            }
        },
        contentPadding = PaddingValues(all = 8.dp)
    )

}

@Preview
@Composable
fun StoriesListPreview() {
    StoriesList(SampleData.storyList)
}