package com.example.happycompose.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val icon: ImageVector, val label: String) {
    object Home : Screen("home", Icons.Filled.Home, "Home")
    object Search : Screen("search", Icons.Filled.Search, "Search")
    object Create : Screen("create", Icons.Filled.Add, "Create")
    object Reels : Screen("reels", Icons.Filled.PlayArrow, "Reels")
    object Profile : Screen("profile", Icons.Filled.Person, "Profile")

    companion object {
        val Items = listOf(Home, Search, Create, Reels, Profile)
    }
}
