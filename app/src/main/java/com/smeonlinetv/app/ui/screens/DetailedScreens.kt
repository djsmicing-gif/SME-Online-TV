package com.smeonlinetv.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.smeonlinetv.app.data.repository.ChannelRepository
import com.smeonlinetv.app.data.repository.VideoRepository
import com.smeonlinetv.app.data.repository.NewsRepository
import com.smeonlinetv.app.ui.components.ChannelCard
import com.smeonlinetv.app.ui.components.VideoCard
import com.smeonlinetv.app.ui.components.NewsCard
import com.smeonlinetv.app.ui.components.TopAppBarWithSearch
import org.koin.compose.koinInject

@Composable
fun HomeScreen(
    navController: NavController,
    channelRepo: ChannelRepository = koinInject(),
    videoRepo: VideoRepository = koinInject(),
    newsRepo: NewsRepository = koinInject()
) {
    val channels = remember { channelRepo.getAllChannels() }
    val videos = remember { videoRepo.getAllVideos().take(4) }
    val news = remember { newsRepo.getAllNews().take(3) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        TopAppBarWithSearch(
            title = "SME Online TV",
            onSearchClick = { navController.navigate("search") }
        )
        
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    "Live Channels",
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            item {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.height(260.dp)
                ) {
                    items(channels.take(4)) { channel ->
                        ChannelCard(
                            name = channel.name,
                            thumbnail = channel.thumbnail,
                            isLive = channel.isLive,
                            onClick = { navController.navigate("live_tv") }
                        )
                    }
                }
            }
            
            item {
                Text(
                    "Popular Videos",
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            item {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.height(240.dp)
                ) {
                    items(videos) { video ->
                        VideoCard(
                            title = video.title,
                            thumbnail = video.thumbnail,
                            duration = video.duration,
                            views = video.views,
                            onClick = { navController.navigate("videos") }
                        )
                    }
                }
            }
            
            item {
                Text(
                    "Latest News",
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            items(news) { article ->
                NewsCard(
                    title = article.title,
                    description = article.description,
                    imageUrl = article.imageUrl,
                    publishedAt = article.publishedAt,
                    onClick = { navController.navigate("news") }
                )
            }
        }
    }
}

@Composable
fun LiveTVScreenEnhanced(
    navController: NavController,
    channelRepo: ChannelRepository = koinInject()
) {
    val channels = remember { channelRepo.getAllChannels() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        TopAppBarWithSearch(
            title = "Live TV",
            onSearchClick = { navController.navigate("search") }
        )
        
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(channels) { channel ->
                ChannelCard(
                    name = channel.name,
                    thumbnail = channel.thumbnail,
                    isLive = channel.isLive,
                    onClick = { }
                )
            }
        }
    }
}

@Composable
fun VideosScreenEnhanced(
    navController: NavController,
    videoRepo: VideoRepository = koinInject()
) {
    val videos = remember { videoRepo.getAllVideos() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        TopAppBarWithSearch(
            title = "Videos",
            onSearchClick = { navController.navigate("search") }
        )
        
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(videos) { video ->
                VideoCard(
                    title = video.title,
                    thumbnail = video.thumbnail,
                    duration = video.duration,
                    views = video.views,
                    onClick = { }
                )
            }
        }
    }
}

@Composable
fun NewsScreenEnhanced(
    navController: NavController,
    newsRepo: NewsRepository = koinInject()
) {
    val news = remember { newsRepo.getAllNews() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        TopAppBarWithSearch(
            title = "News",
            onSearchClick = { navController.navigate("search") }
        )
        
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(news) { article ->
                NewsCard(
                    title = article.title,
                    description = article.description,
                    imageUrl = article.imageUrl,
                    publishedAt = article.publishedAt,
                    onClick = { }
                )
            }
        }
    }
}
