package com.smeonlinetv.app.data.repository

import com.smeonlinetv.app.data.model.Video

class VideoRepository {
    fun getAllVideos(): List<Video> {
        return listOf(
            Video(
                id = "1",
                title = "Video 1",
                thumbnail = "https://via.placeholder.com/400x225?text=Video+1",
                videoUrl = "https://example.com/video1",
                duration = 600,
                views = 1000
            ),
            Video(
                id = "2",
                title = "Video 2",
                thumbnail = "https://via.placeholder.com/400x225?text=Video+2",
                videoUrl = "https://example.com/video2",
                duration = 900,
                views = 2000
            )
        )
    }
    
    fun searchVideos(query: String): List<Video> {
        return getAllVideos().filter { it.title.contains(query, ignoreCase = true) }
    }
}
