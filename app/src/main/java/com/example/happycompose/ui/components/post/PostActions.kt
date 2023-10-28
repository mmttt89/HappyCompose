package com.example.happycompose.ui.components.post

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.happycompose.R
import com.example.happycompose.data.SampleData
import com.example.happycompose.data.models.Post
import com.example.happycompose.ui.components.common.AppIcon
import com.example.happycompose.ui.theme.labelSmallCustom

@Composable
fun PostActions(post: Post) {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    AppIcon(
                        id = R.drawable.heart_outline,
                        contentDescription = "like",
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    AppIcon(
                        id = R.drawable.comment_outline, contentDescription = "comment",
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    AppIcon(
                        id = R.drawable.send_outline, contentDescription = "send",
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
            Box() {
                AppIcon(
                    id = R.drawable.bookmark_outline,
                    contentDescription = "bookmark",
                )
            }
        }
        Text(
            text = "${post.likesTotal} likes",
            style = MaterialTheme.typography.labelSmallCustom,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Composable
@Preview
fun PostActionsPreview() {
    PostActions(post = SampleData.singlePostItem)
}