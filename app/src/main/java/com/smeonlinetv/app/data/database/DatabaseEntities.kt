package com.smeonlinetv.app.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "watch_history")
data class WatchHistoryEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val contentId: String,
    val contentType: String, // "channel", "video", "news"
    val contentTitle: String,
    val contentThumbnail: String,
    val watchedAt: Long = System.currentTimeMillis(),
    val watchPosition: Long = 0
)

@Entity(tableName = "favorites")
data class FavoriteEntity(
    @PrimaryKey val contentId: String,
    val contentType: String,
    val contentTitle: String,
    val contentThumbnail: String,
    val addedAt: Long = System.currentTimeMillis()
)
