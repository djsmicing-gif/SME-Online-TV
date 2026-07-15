package com.smeonlinetv.app.data.repository

import com.smeonlinetv.app.data.models.Video
import com.smeonlinetv.app.data.remote.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class VideoRepository @Inject constructor(
    private val apiService: ApiService
) {
    fun getVideos(page: Int = 1): Flow<Result<List<Video>>> = flow {
        try {
            val response = apiService.getVideos(page = page)
            if (response.success && response.data != null) {
                emit(Result.success(response.data))
            } else {
                emit(Result.failure(Exception(response.error ?: "Unknown error")))
            }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    fun getVideoDetail(videoId: String): Flow<Result<Video>> = flow {
        try {
            val response = apiService.getVideoDetail(videoId)
            if (response.success && response.data != null) {
                emit(Result.success(response.data))
            } else {
                emit(Result.failure(Exception(response.error ?: "Unknown error")))
            }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    fun getVideosByCategory(category: String, page: Int = 1): Flow<Result<List<Video>>> = flow {
        try {
            val response = apiService.getVideosByCategory(category, page)
            if (response.success && response.data != null) {
                emit(Result.success(response.data))
            } else {
                emit(Result.failure(Exception(response.error ?: "Unknown error")))
            }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    fun getFeaturedContent(): Flow<Result<List<Video>>> = flow {
        try {
            val response = apiService.getFeaturedContent()
            if (response.success && response.data != null) {
                emit(Result.success(response.data))
            } else {
                emit(Result.failure(Exception(response.error ?: "Unknown error")))
            }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    fun getTrendingContent(): Flow<Result<List<Video>>> = flow {
        try {
            val response = apiService.getTrendingContent()
            if (response.success && response.data != null) {
                emit(Result.success(response.data))
            } else {
                emit(Result.failure(Exception(response.error ?: "Unknown error")))
            }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
}
