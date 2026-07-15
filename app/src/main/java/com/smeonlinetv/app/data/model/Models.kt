package com.smeonlinetv.app.data.model

data class Channel(
    val id: String,
    val name: String,
    val thumbnail: String,
    val streamUrl: String,
    val isLive: Boolean = false
)

data class Video(
    val id: String,
    val title: String,
    val thumbnail: String,
    val videoUrl: String,
    val duration: Long,
    val views: Int
)

data class NewsArticle(
    val id: String,
    val title: String,
    val description: String,
    val imageUrl: String,
    val publishedAt: String,
    val content: String
)

data class User(
    val id: String,
    val name: String,
    val email: String,
    val profileImage: String,
    val isVerified: Boolean = false
)
