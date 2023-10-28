package com.example.happycompose.ui.components.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent

@Composable
fun AppImage(url: String) {
    SubcomposeAsyncImage(
        model = url,
        contentDescription = "",
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        contentScale = ContentScale.Crop,
        alignment = Alignment.Center,
    ) {
        when (painter.state) {
            is AsyncImagePainter.State.Loading -> {
                StateContentWrapper {
                    CircularProgressIndicator(
                        modifier = Modifier.size(40.dp),
                        color = Color.Gray
                    )
                }
            }

            is AsyncImagePainter.State.Error -> {
                StateContentWrapper {
                    Text(text = "Sorry, Loading Error")
                }
            }

            is AsyncImagePainter.State.Empty -> {
                StateContentWrapper {
                    Text(text = "Invalid Url")
                }
            }

            else -> {
                SubcomposeAsyncImageContent()
            }
        }
    }
}

@Composable
fun StateContentWrapper(content: @Composable () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        content()
    }
}