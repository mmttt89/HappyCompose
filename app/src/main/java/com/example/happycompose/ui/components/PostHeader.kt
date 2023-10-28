package com.example.happycompose.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.happycompose.data.SampleData
import com.example.happycompose.ui.theme.HappyComposeTheme

@Composable
fun PostHeader() {
    var isContextMenuVisible by remember {
        mutableStateOf(false)
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
//                CircleProfileButton(
//                    storyItemData = SampleData.singleStoryItemData,
//                    width = 40.dp,
//                    border = 4.dp
//                )
                Text(
                    text = "username",
                    modifier = Modifier.padding(horizontal = 8.dp),
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
        Box {
            IconButton(
                onClick = {
                    isContextMenuVisible = true
                }
            ) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Open Context Menu"
                )
            }
            // context menu here
            DropdownMenu(
                expanded = isContextMenuVisible,
                onDismissRequest = {
                    isContextMenuVisible = false
                }) {
                DropdownMenuItem(
                    text = { Text(text = "save") },
                    onClick = {
                        isContextMenuVisible = false
                    })
                DropdownMenuItem(
                    text = { Text(text = "later") },
                    onClick = {
                        isContextMenuVisible = false
                    })
            }
        }
    }
}

@Preview
@Composable
fun PostHeaderPreview() {
    HappyComposeTheme() {
        PostHeader()
    }
}