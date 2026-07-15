package com.smeonlinetv.app.data.repository

import com.smeonlinetv.app.data.models.User
import com.smeonlinetv.app.data.models.Video
import com.smeonlinetv.app.data.remote.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val apiService: ApiService
) {
    fun getUserProfile(): Flow<Result<User>> = flow {
        try {
            val response = apiService.getUserProfile()
            if (response.success && response.data != null) {
                emit(Result.success(response.data))
            } else {
                emit(Result.failure(Exception(response.error ?: "Unknown error")))
            }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    fun updateUserProfile(user: User): Flow<Result<User>> = flow {
        try {
            val response = apiService.updateUserProfile(user)
            if (response.success && response.data != null) {
                emit(Result.success(response.data))
            } else {
                emit(Result.failure(Exception(response.error ?: "Unknown error")))
            }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    fun getWatchHistory(): Flow<Result<List<Video>>> = flow {
        try {
            val response = apiService.getWatchHistory()
            if (response.success && response.data != null) {
                emit(Result.success(response.data))
            } else {
                emit(Result.failure(Exception(response.error ?: "Unknown error")))
            }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    fun addToWatchHistory(videoId: String): Flow<Result<String>> = flow {
        try {
            val response = apiService.addToWatchHistory(videoId)
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
