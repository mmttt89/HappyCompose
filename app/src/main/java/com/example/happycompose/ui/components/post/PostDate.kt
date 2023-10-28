package com.example.happycompose.ui.components.post

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun PostDate() {
    Text(text = "24 Oct", style = MaterialTheme.typography.labelSmall)
}