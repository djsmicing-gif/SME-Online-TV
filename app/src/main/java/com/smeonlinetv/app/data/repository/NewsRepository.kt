package com.smeonlinetv.app.data.repository

import com.smeonlinetv.app.data.models.News
import com.smeonlinetv.app.data.remote.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val apiService: ApiService
) {
    fun getNews(page: Int = 1): Flow<Result<List<News>>> = flow {
        try {
            val response = apiService.getNews(page = page)
            if (response.success && response.data != null) {
                emit(Result.success(response.data))
            } else {
                emit(Result.failure(Exception(response.error ?: "Unknown error")))
            }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    fun getNewsDetail(newsId: String): Flow<Result<News>> = flow {
        try {
            val response = apiService.getNewsDetail(newsId)
            if (response.success && response.data != null) {
                emit(Result.success(response.data))
            } else {
                emit(Result.failure(Exception(response.error ?: "Unknown error")))
            }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    fun getNewsByCategory(category: String, page: Int = 1): Flow<Result<List<News>>> = flow {
        try {
            val response = apiService.getNewsByCategory(category, page)
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
