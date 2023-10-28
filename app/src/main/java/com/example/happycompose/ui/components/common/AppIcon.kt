package com.example.happycompose.ui.components.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp

@Composable
fun AppIcon(
    id: Int,
    contentDescription: String? = "Not Provided",
    modifier: Modifier = Modifier,
) {

    val finalModifier = Modifier
        .size(24.dp)
        .clickable {}

    Icon(
        imageVector = ImageVector.vectorResource(id),
        contentDescription = contentDescription,
        tint = MaterialTheme.colorScheme.secondary,
        modifier = finalModifier.then(modifier)
    )
}