package com.smeonlinetv.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.smeonlinetv.app.data.repository.UserRepository
import com.smeonlinetv.app.ui.components.SearchBar
import org.koin.compose.koinInject

@Composable
fun ProfileScreenEnhanced(
    navController: NavController,
    userRepo: UserRepository = koinInject()
) {
    val user = remember { userRepo.getCurrentUser() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
    ) {
        TopAppBar(
            title = { Text("My Profile") },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        )
        
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = user.profileImage,
                contentDescription = user.name,
                modifier = Modifier
                    .size(120.dp)
                    .clip(androidx.compose.foundation.shape.CircleShape),
                contentScale = ContentScale.Crop
            )
            
            Text(
                user.name,
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(top = 16.dp)
            )
            
            if (user.isVerified) {
                Row(
                    modifier = Modifier.padding(top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        Icons.Default.CheckCircle,
                        contentDescription = "Verified",
                        modifier = Modifier.size(16.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        "Verified",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
            
            Text(
                user.email,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(top = 8.dp)
            )
            
            Divider(
                modifier = Modifier.padding(vertical = 24.dp),
                color = MaterialTheme.colorScheme.surfaceVariant
            )
            
            ProfileMenuItem(
                icon = Icons.Default.Settings,
                title = "Settings",
                onClick = { }
            )
            
            ProfileMenuItem(
                icon = Icons.Default.DarkMode,
                title = "Dark Mode",
                onClick = { }
            )
            
            ProfileMenuItem(
                icon = Icons.Default.Info,
                title = "About",
                onClick = { }
            )
            
            ProfileMenuItem(
                icon = Icons.Default.Help,
                title = "Help & Support",
                onClick = { }
            )
            
            Spacer(modifier = Modifier.weight(1f))
            
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.error
                )
            ) {
                Icon(
                    Icons.Default.Logout,
                    contentDescription = "Logout",
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text("Logout")
            }
        }
    }
}

@Composable
fun ProfileMenuItem(
    icon: androidx.compose.material.icons.twopone.Icon? = null,
    title: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(androidx.compose.foundation.shape.RoundedCornerShape(8.dp))
            .androidx.compose.foundation.clickable(onClick = onClick)
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            if (icon != null) {
                Icon(
                    icon,
                    contentDescription = title,
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
            Text(
                title,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        Icon(
            Icons.Default.ChevronRight,
            contentDescription = "Navigate",
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
fun SearchScreenEnhanced(
    navController: NavController,
    channelRepo: ChannelRepository = koinInject(),
    videoRepo: VideoRepository = koinInject(),
    newsRepo: NewsRepository = koinInject()
) {
    var searchQuery by remember { mutableStateOf("") }
    var isSearching by remember { mutableStateOf(false) }
    
    val channels = remember(searchQuery) { 
        if (searchQuery.isNotEmpty()) channelRepo.searchChannels(searchQuery) else emptyList()
    }
    val videos = remember(searchQuery) { 
        if (searchQuery.isNotEmpty()) videoRepo.searchVideos(searchQuery) else emptyList()
    }
    val news = remember(searchQuery) { 
        if (searchQuery.isNotEmpty()) newsRepo.searchNews(searchQuery) else emptyList()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        SearchBar(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            onSearch = { isSearching = searchQuery.isNotEmpty() },
            modifier = Modifier.padding(top = 16.dp)
        )
        
        if (searchQuery.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Search for channels, videos, and news",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        } else if (channels.isEmpty() && videos.isEmpty() && news.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "No results found",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        } else {
            androidx.compose.foundation.lazy.LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                if (channels.isNotEmpty()) {
                    item {
                        Text(
                            "Channels",
                            style = MaterialTheme.typography.headlineSmall,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                    items(channels.size) { index ->
                        ChannelCard(
                            name = channels[index].name,
                            thumbnail = channels[index].thumbnail,
                            isLive = channels[index].isLive,
                            onClick = { }
                        )
                    }
                }
                
                if (videos.isNotEmpty()) {
                    item {
                        Text(
                            "Videos",
                            style = MaterialTheme.typography.headlineSmall,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                    items(videos.size) { index ->
                        VideoCard(
                            title = videos[index].title,
                            thumbnail = videos[index].thumbnail,
                            duration = videos[index].duration,
                            views = videos[index].views,
                            onClick = { }
                        )
                    }
                }
                
                if (news.isNotEmpty()) {
                    item {
                        Text(
                            "News",
                            style = MaterialTheme.typography.headlineSmall,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                    items(news.size) { index ->
                        NewsCard(
                            title = news[index].title,
                            description = news[index].description,
                            imageUrl = news[index].imageUrl,
                            publishedAt = news[index].publishedAt,
                            onClick = { }
                        )
                    }
                }
            }
        }
    }
}
