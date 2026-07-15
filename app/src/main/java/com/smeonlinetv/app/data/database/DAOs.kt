package com.smeonlinetv.app.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WatchHistoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToHistory(item: WatchHistoryEntity)
    
    @Query("SELECT * FROM watch_history ORDER BY watchedAt DESC LIMIT :limit")
    fun getHistory(limit: Int = 20): Flow<List<WatchHistoryEntity>>
    
    @Query("DELETE FROM watch_history WHERE id = :id")
    suspend fun removeFromHistory(id: Int)
    
    @Query("DELETE FROM watch_history")
    suspend fun clearHistory()
}

@Dao
interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavorite(item: FavoriteEntity)
    
    @Query("SELECT * FROM favorites ORDER BY addedAt DESC")
    fun getAllFavorites(): Flow<List<FavoriteEntity>>
    
    @Query("SELECT * FROM favorites WHERE contentType = :contentType")
    fun getFavoritesByType(contentType: String): Flow<List<FavoriteEntity>>
    
    @Delete
    suspend fun removeFavorite(item: FavoriteEntity)
    
    @Query("DELETE FROM favorites")
    suspend fun clearFavorites()
    
    @Query("SELECT COUNT(*) FROM favorites WHERE contentId = :contentId")
    suspend fun isFavorite(contentId: String): Int
}
