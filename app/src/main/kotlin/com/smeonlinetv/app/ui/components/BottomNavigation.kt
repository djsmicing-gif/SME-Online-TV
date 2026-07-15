package com.smeonlinetv.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Newspaper
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.VideoLibrary
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.smeonlinetv.app.ui.navigation.NavDestination
import com.smeonlinetv.app.ui.theme.PrimaryBlue

@Composable
fun BottomNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(MaterialTheme.colorScheme.surface),
        verticalAlignment = Alignment.CenterVertically
    ) {
        NavItem(
            icon = Icons.Rounded.Home,
            label = "Home",
            onClick = {
                navController.navigate(NavDestination.Home.route) {
                    popUpTo(NavDestination.Home.route) { inclusive = true }
                }
            },
            modifier = Modifier.weight(1f)
        )

        NavItem(
            icon = Icons.Rounded.PlayArrow,
            label = "Live TV",
            onClick = {
                navController.navigate(NavDestination.LiveTV.route) {
                    popUpTo(NavDestination.LiveTV.route) { inclusive = true }
                }
            },
            modifier = Modifier.weight(1f)
        )

        NavItem(
            icon = Icons.Rounded.VideoLibrary,
            label = "Videos",
            onClick = {
                navController.navigate(NavDestination.Videos.route) {
                    popUpTo(NavDestination.Videos.route) { inclusive = true }
                }
            },
            modifier = Modifier.weight(1f)
        )

        NavItem(
            icon = Icons.Rounded.Newspaper,
            label = "News",
            onClick = {
                navController.navigate(NavDestination.News.route) {
                    popUpTo(NavDestination.News.route) { inclusive = true }
                }
            },
            modifier = Modifier.weight(1f)
        )

        NavItem(
            icon = Icons.Rounded.Search,
            label = "Search",
            onClick = {
                navController.navigate(NavDestination.Search.route) {
                    popUpTo(NavDestination.Search.route) { inclusive = true }
                }
            },
            modifier = Modifier.weight(1f)
        )

        NavItem(
            icon = Icons.Rounded.AccountCircle,
            label = "Profile",
            onClick = {
                navController.navigate(NavDestination.Profile.route) {
                    popUpTo(NavDestination.Profile.route) { inclusive = true }
                }
            },
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun NavItem(
    icon: androidx.compose.material.icons.materialIcon,
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                modifier = Modifier.size(24.dp),
                tint = PrimaryBlue
            )
            Text(
                text = label,
                fontSize = 10.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}
