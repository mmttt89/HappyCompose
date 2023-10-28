package com.example.happycompose.ui.components.post

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.happycompose.data.SampleData
import com.example.happycompose.data.models.Post
import com.example.happycompose.ui.theme.HappyComposeTheme

@Composable
fun PostItem(post: Post) {
    Column {
        PostHeader(post.user)
        MediaCarousel(post.medias)
        Column(
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            PostActions(post)
            Spacer(modifier = Modifier.height(10.dp))
            PostDescription(post)
            TopComments()
            PostDate()
        }
    }
}

@Composable
@Preview
fun MediaCarouselPreview() {
    HappyComposeTheme {
        PostItem(SampleData.singlePostItem)
    }
}