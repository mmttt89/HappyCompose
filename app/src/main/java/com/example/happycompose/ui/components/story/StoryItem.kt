package com.example.happycompose.ui.components.story

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.happycompose.data.SampleData
import com.example.happycompose.data.models.SingleStoryItem
import com.example.happycompose.ui.components.common.CircleProfileButton
import com.example.happycompose.ui.theme.HappyComposeTheme

@Composable
fun StoryItem(storyItem: SingleStoryItem) {
    val width = 80.dp
    val photo = if (storyItem.user?.photo?.isNotEmpty() == true) storyItem.user?.photo else ""
    val username =
        if (storyItem.user?.username?.isNotEmpty() == true) storyItem.user.username else ""

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(width)
    ) {
        CircleProfileButton(photo)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = username,
            style = MaterialTheme.typography.labelSmall,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Preview
@Composable
fun StoryItemPreview() {
    val storyItem: SingleStoryItem = SampleData.singleStoryItem
    HappyComposeTheme() {
        StoryItem(storyItem)
    }
}