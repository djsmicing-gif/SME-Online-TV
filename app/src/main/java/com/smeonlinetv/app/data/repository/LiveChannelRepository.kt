package com.smeonlinetv.app.data.repository

import com.smeonlinetv.app.data.models.LiveChannel
import com.smeonlinetv.app.data.remote.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LiveChannelRepository @Inject constructor(
    private val apiService: ApiService
) {
    fun getLiveChannels(): Flow<Result<List<LiveChannel>>> = flow {
        try {
            val response = apiService.getLiveChannels()
            if (response.success && response.data != null) {
                emit(Result.success(response.data))
            } else {
                emit(Result.failure(Exception(response.error ?: "Unknown error")))
            }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    fun getChannelDetail(channelId: String): Flow<Result<LiveChannel>> = flow {
        try {
            val response = apiService.getChannelDetail(channelId)
            if (response.success && response.data != null) {
                emit(Result.success(response.data))
            } else {
                emit(Result.failure(Exception(response.error ?: "Unknown error")))
            }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    fun getLiveChannelsByCategory(category: String): Flow<Result<List<LiveChannel>>> = flow {
        try {
            val response = apiService.getLiveChannels(category = category)
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
