package com.example.happycompose.ui.components.post

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HorizontalDots(length: Int, position: Int = 0){
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth(),
        content = {
            items(length) {
                val color = if(position == it) Color.Black else Color.Gray
                val scale = if(position == it) 1.2f else 1.0f
                Box(
                    modifier = Modifier
                        .size(6.dp)
                        .scale(scale)
                        .clip(CircleShape)
                        .background(color)
                )
                Spacer(modifier = Modifier.width(1.dp))
            }
        })
}