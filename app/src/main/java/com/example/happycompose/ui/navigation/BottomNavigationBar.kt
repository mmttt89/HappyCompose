package com.example.happycompose.ui.navigation

import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.*
import com.example.happycompose.di.Constants


@Composable
fun BottomNavigationBar(navController: NavHostController) {

    BottomNavigation(
        backgroundColor = MaterialTheme.colorScheme.background,
        modifier = Modifier.height(45.dp),

        ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        Screen.Items.forEach { navItem ->
            BottomNavigationItem(
                selected = currentRoute == navItem.route,
                onClick = {
                    navController.navigate(navItem.route)
                },
                icon = { Icon(imageVector = navItem.icon, contentDescription = navItem.label) },
            )
        }
    }
}