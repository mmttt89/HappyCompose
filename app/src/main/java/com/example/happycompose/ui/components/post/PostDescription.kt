package com.example.happycompose.ui.components.post

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.happycompose.data.SampleData
import com.example.happycompose.data.models.Post
import com.example.happycompose.ui.theme.labelSmallCustom
import com.example.happycompose.ui.theme.smallTextCustom

@Composable
fun PostDescription(post: Post) {
    Text(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontWeight = MaterialTheme.typography.labelSmallCustom.fontWeight,
                    fontSize = MaterialTheme.typography.labelSmallCustom.fontSize,
                )
            ) {
                append(post.user.username)
            }
            append(" ")
            withStyle(
                style = SpanStyle(
                    fontWeight = MaterialTheme.typography.smallTextCustom.fontWeight,
                    fontSize = MaterialTheme.typography.smallTextCustom.fontSize
                )
            ) {
                append(post.description)
            }
        },
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
    )
}

@Preview
@Composable
fun PostDescriptionPreview() {
    PostDescription(post = SampleData.singlePostItem)
}