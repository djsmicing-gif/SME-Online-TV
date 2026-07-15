package com.smeonlinetv.app.data.repository

import com.smeonlinetv.app.data.models.SearchResult
import com.smeonlinetv.app.data.remote.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchRepository @Inject constructor(
    private val apiService: ApiService
) {
    fun search(query: String, type: String? = null): Flow<Result<List<SearchResult>>> = flow {
        try {
            if (query.isBlank()) {
                emit(Result.success(emptyList()))
                return@flow
            }
            val response = apiService.search(query, type)
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
