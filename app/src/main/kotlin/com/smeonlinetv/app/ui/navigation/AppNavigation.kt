package com.smeonlinetv.app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.smeonlinetv.app.ui.screens.home.HomeScreen
import com.smeonlinetv.app.ui.screens.livetv.LiveTVScreen
import com.smeonlinetv.app.ui.screens.videos.VideosScreen
import com.smeonlinetv.app.ui.screens.news.NewsScreen
import com.smeonlinetv.app.ui.screens.search.SearchScreen
import com.smeonlinetv.app.ui.screens.profile.ProfileScreen
import com.smeonlinetv.app.ui.screens.splash.SplashScreen
import com.smeonlinetv.app.ui.screens.player.PlayerDetailScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavDestination.Splash.route
    ) {
        composable(NavDestination.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(NavDestination.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(NavDestination.LiveTV.route) {
            LiveTVScreen(navController = navController)
        }
        composable(NavDestination.Videos.route) {
            VideosScreen(navController = navController)
        }
        composable(NavDestination.News.route) {
            NewsScreen(navController = navController)
        }
        composable(NavDestination.Search.route) {
            SearchScreen(navController = navController)
        }
        composable(NavDestination.Profile.route) {
            ProfileScreen(navController = navController)
        }
        composable(NavDestination.PlayerDetail.route) { backStackEntry ->
            val contentId = backStackEntry.arguments?.getString("contentId") ?: ""
            PlayerDetailScreen(navController = navController, contentId = contentId)
        }
    }
}
