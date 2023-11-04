package com.example.happycompose.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.happycompose.ui.feature.CreateScreen
import com.example.happycompose.ui.feature.ProfileScreen
import com.example.happycompose.ui.feature.ReelsScreen
import com.example.happycompose.ui.feature.SearchScreen
import com.example.happycompose.ui.feature.feed.HomePage

@Composable
fun NavHostContainer(
    navController: NavHostController,
    padding: PaddingValues
) {

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = Modifier.padding(paddingValues = padding),
        builder = {
            composable(Screen.Home.route) {
                HomePage()
            }
            composable(Screen.Search.route) {
                SearchScreen()
            }
            composable(Screen.Create.route) {
                CreateScreen()
            }
            composable(Screen.Reels.route) {
                ReelsScreen()
            }
            composable(Screen.Profile.route) {
                ProfileScreen()
            }
        })
}