package com.example.happycompose.ui.components.post

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.happycompose.data.SampleData
import com.example.happycompose.data.models.User
import com.example.happycompose.ui.components.common.CircleProfileButton
import com.example.happycompose.ui.theme.HappyComposeTheme
import com.example.happycompose.ui.theme.labelSmallCustom

@Composable
fun PostHeader(user: User) {
    var isContextMenuVisible by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.5.dp)
                .background(color = MaterialTheme.colorScheme.secondary)
        )
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
                CircleProfileButton(
                    imageUrl = user.photo.toString(),
                    width = 40.dp,
                    border = 4.dp
                )
                Text(
                    text = user.username,
                    modifier = Modifier.padding(horizontal = 8.dp),
                    style = MaterialTheme.typography.labelSmallCustom
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
                    contentDescription = "Open Context Menu",
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

@Preview("Light Theme", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PostHeaderPreview() {
    HappyComposeTheme {
        PostHeader(SampleData.user)
    }
}