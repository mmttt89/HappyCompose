package com.example.happycompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.happycompose.R
import com.example.happycompose.data.models.StoryItemData

@Composable
fun CircleProfileButton(imageUrl: String, width: Dp = 80.dp, border: Dp = 8.dp) {
    val innerCircleSize = (width - border)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(width)
    ) {
        Box(
            modifier = Modifier
                .size(width)
                .clip(CircleShape)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color(0xFFB236FF), Color(0xFFFF4161))
                    )
                )
                .padding((width - innerCircleSize) / 2)

        ) {
            Box(
                modifier = Modifier
                    .size(innerCircleSize)
                    .background(Color.White, CircleShape)
                    .padding(all = 3.dp)
            ) {
                CircleImage(imageUrl = imageUrl)
            }
        }
    }
}

@Composable
fun CircleImage(imageUrl: String) {

    if (imageUrl.isEmpty()) {
        Image(
            painter = painterResource(id = R.drawable.male_avatar),
            contentDescription = "avatar",
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
    } else {
        val painter = rememberAsyncImagePainter(model = imageUrl)
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape),
            contentScale = ContentScale.FillBounds
        )
    }
}

@Preview(
    name = "circle button"
)
@Composable
fun StoryCircleButtonPreview() {
    CircleProfileButton(imageUrl = "")
}