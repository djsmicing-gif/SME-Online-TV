package com.smeonlinetv.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.smeonlinetv.app.ui.screens.SplashScreen
import com.smeonlinetv.app.ui.screens.HomeScreen
import com.smeonlinetv.app.ui.screens.LiveTVScreen
import com.smeonlinetv.app.ui.screens.VideosScreen
import com.smeonlinetv.app.ui.screens.NewsScreen
import com.smeonlinetv.app.ui.screens.SearchScreen
import com.smeonlinetv.app.ui.screens.ProfileScreen

@Composable
fun SMENavigation() {
    val navController = rememberNavController()
    
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(navController)
        }
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.LiveTV.route) {
            LiveTVScreen(navController)
        }
        composable(Screen.Videos.route) {
            VideosScreen(navController)
        }
        composable(Screen.News.route) {
            NewsScreen(navController)
        }
        composable(Screen.Search.route) {
            SearchScreen(navController)
        }
        composable(Screen.Profile.route) {
            ProfileScreen(navController)
        }
        composable(Screen.VideoDetail.route) { backStackEntry ->
            val videoId = backStackEntry.arguments?.getString("videoId") ?: ""
            // VideoDetailScreen(navController, videoId)
        }
    }
}
