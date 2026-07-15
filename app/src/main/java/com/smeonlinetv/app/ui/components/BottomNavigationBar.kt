package com.smeonlinetv.app.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.smeonlinetv.app.navigation.Screen

@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    currentRoute: String
) {
    NavigationBar {
        NavigationBarItem(
            selected = currentRoute == "home",
            onClick = {
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.Home.route) { inclusive = true }
                }
            },
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") }
        )
        
        NavigationBarItem(
            selected = currentRoute == "live_tv",
            onClick = {
                navController.navigate(Screen.LiveTV.route) {
                    popUpTo(Screen.Home.route) { inclusive = false }
                }
            },
            icon = { Icon(Icons.Default.PlayArrow, contentDescription = "Live TV") },
            label = { Text("Live TV") }
        )
        
        NavigationBarItem(
            selected = currentRoute == "videos",
            onClick = {
                navController.navigate(Screen.Videos.route) {
                    popUpTo(Screen.Home.route) { inclusive = false }
                }
            },
            icon = { Icon(Icons.Default.PlayArrow, contentDescription = "Videos") },
            label = { Text("Videos") }
        )
        
        NavigationBarItem(
            selected = currentRoute == "search",
            onClick = {
                navController.navigate(Screen.Search.route) {
                    popUpTo(Screen.Home.route) { inclusive = false }
                }
            },
            icon = { Icon(Icons.Default.Search, contentDescription = "Search") },
            label = { Text("Search") }
        )
        
        NavigationBarItem(
            selected = currentRoute == "profile",
            onClick = {
                navController.navigate(Screen.Profile.route) {
                    popUpTo(Screen.Home.route) { inclusive = false }
                }
            },
            icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
            label = { Text("Profile") }
        )
    }
}
