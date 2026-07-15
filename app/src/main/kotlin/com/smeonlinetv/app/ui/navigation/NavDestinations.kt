package com.smeonlinetv.app.ui.navigation

sealed class NavDestination(val route: String) {
    object Splash : NavDestination("splash")
    object Home : NavDestination("home")
    object LiveTV : NavDestination("livetv")
    object Videos : NavDestination("videos")
    object News : NavDestination("news")
    object Search : NavDestination("search")
    object Profile : NavDestination("profile")
    object PlayerDetail : NavDestination("player/{contentId}") {
        fun createRoute(contentId: String) = "player/$contentId"
    }
}
