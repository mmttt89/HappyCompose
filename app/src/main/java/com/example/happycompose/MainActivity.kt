package com.example.happycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.happycompose.ui.components.MainHeader
import com.example.happycompose.ui.components.PostHeader
import com.example.happycompose.ui.components.StoriesList
import com.example.happycompose.ui.feature.feed.MainPage
import com.example.happycompose.ui.theme.HappyComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Column {
//                        MainHeader()
//                        StoriesList()
//                        PostHeader()
//                    }
                    MainPage()

                }
            }
        }
    }
}