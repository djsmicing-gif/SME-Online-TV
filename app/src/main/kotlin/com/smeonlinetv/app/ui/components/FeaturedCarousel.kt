package com.smeonlinetv.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import com.smeonlinetv.app.ui.theme.BackgroundTertiary

data class FeaturedContent(
    val id: String,
    val title: String,
    val thumbnail: String
)

@Composable
fun FeaturedCarousel(navController: NavHostController) {
    val featuredItems = listOf(
        FeaturedContent("1", "Featured 1", ""),
        FeaturedContent("2", "Featured 2", ""),
        FeaturedContent("3", "Featured 3", ""),
        FeaturedContent("4", "Featured 4", "")
    )

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        items(featuredItems) { item ->
            Box(
                modifier = Modifier
                    .padding(end = 12.dp)
                    .width(280.dp)
                    .height(160.dp)
                    .background(BackgroundTertiary)
                    .clickable {
                        navController.navigate(NavDestination.PlayerDetail.createRoute(item.id))
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = item.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

import androidx.compose.foundation.layout.width
