package com.smeonlinetv.app.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Home : Screen("home")
    object LiveTV : Screen("live_tv")
    object Videos : Screen("videos")
    object News : Screen("news")
    object Search : Screen("search")
    object Profile : Screen("profile")
    object VideoDetail : Screen("video_detail/{videoId}") {
        fun createRoute(videoId: String) = "video_detail/$videoId"
    }
}
