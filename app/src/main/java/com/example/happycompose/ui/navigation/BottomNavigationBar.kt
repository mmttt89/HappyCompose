package com.example.happycompose.ui.navigation

import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState


@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = remember {
        listOf(
            Screen.Home,
            Screen.Search,
            Screen.Create,
            Screen.Reels,
            Screen.Profile
        )
    }
    BottomNavigation(
        backgroundColor = MaterialTheme.colorScheme.background,
        modifier = Modifier.height(45.dp),

        ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { navItem ->
            BottomNavigationItem(
                selected = currentRoute == navItem.route,
                onClick = {
                    navController.navigate(navItem.route){
                        launchSingleTop = true
                    }
                },
                icon = { Icon(imageVector = navItem.icon, contentDescription = navItem.label) },
            )
        }
    }
}