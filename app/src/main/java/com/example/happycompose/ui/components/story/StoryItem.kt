package com.example.happycompose.ui.components.story

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.happycompose.R
import com.example.happycompose.data.SampleData
import com.example.happycompose.data.models.SingleStoryItem
import com.example.happycompose.ui.components.common.CircleImage
import com.example.happycompose.ui.components.common.CircleProfileButton
import com.example.happycompose.ui.theme.HappyComposeTheme
import com.example.happycompose.ui.theme.LiveColor

@Composable
fun StoryItem(storyItem: SingleStoryItem) {
    val width = 80.dp
    val photo = if (storyItem.user?.photo?.isNotEmpty() == true) storyItem.user?.photo else ""
    val username =
        if (storyItem.user?.username?.isNotEmpty() == true) storyItem.user.username else ""

    val valueStroke by rememberInfiniteTransition().animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = LinearEasing
            )
        )
    )

    val colors = listOf(
        Color(0xFF405DE6),
        Color(0xFFC13584),
        Color(0xFFFD1D1D),
        Color(0xFFFFDC80)
    )
    var gradientBrush by remember {
        mutableStateOf(
            Brush.horizontalGradient(
                colors = colors,
                startX = -10.0f,
                endX = 400.0f,
                tileMode = TileMode.Repeated
            )
        )
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(width)
    ) {
        if (storyItem.isLive == true) {
            Box(
                modifier = Modifier
                    .drawBehind {
                        rotate(valueStroke) {
                            drawCircle(
                                gradientBrush, style = Stroke(width = 12.dp.value)
                            )
                        }
                    }
                    .size(width)
                    .padding(6.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                CircleImage(imageUrl = photo)
                Box(
                    modifier = Modifier
                        .offset(y = 10.dp)
                        .width(40.dp)
                        .height(20.dp)
                        .background(LiveColor, shape = RoundedCornerShape(60.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Live",
                        style = MaterialTheme.typography.labelSmall,
                        textAlign = TextAlign.Center
                    )
                }
            }
        } else {
            CircleProfileButton(photo)
        }
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