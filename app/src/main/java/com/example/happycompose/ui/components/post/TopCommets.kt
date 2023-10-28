package com.example.happycompose.ui.components.post

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.happycompose.ui.theme.labelSmallCustom

@Composable
fun TopComments() {
    Text(
        text = "View all 197 comments",
        style = MaterialTheme.typography.labelSmallCustom,
        color = MaterialTheme.colorScheme.secondary
    )
}

@Composable
@Preview
fun TopCommentsPreview() {
    TopComments()
}