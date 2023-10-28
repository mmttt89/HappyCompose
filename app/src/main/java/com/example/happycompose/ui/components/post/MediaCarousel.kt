package com.example.happycompose.ui.components.post

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.happycompose.data.models.Media
import com.example.happycompose.ui.components.common.AppImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState


@OptIn(ExperimentalPagerApi::class)
@Composable
fun MediaCarousel(medias: List<Media>) {
    val pageState = rememberPagerState()
    var position: Int by remember { mutableIntStateOf(0) }
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    Column {
        Box(
            modifier = Modifier
                .size(width = screenWidth, height = 360.dp)
        ) {
            HorizontalPager(
                state = pageState,
                count = medias.size
            ) { page ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    medias[page].url?.let {
                        AppImage(url = it)
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        HorizontalDots(medias.size, position)
        LaunchedEffect(pageState.currentPage) {
            position = pageState.currentPage
        }
    }
}