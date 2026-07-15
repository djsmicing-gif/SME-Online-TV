package com.smeonlinetv.app.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smeonlinetv.app.data.models.Video
import com.smeonlinetv.app.data.repository.VideoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val videoRepository: VideoRepository
) : ViewModel() {

    private val _featuredContent = MutableStateFlow<List<Video>>(emptyList())
    val featuredContent: StateFlow<List<Video>> = _featuredContent.asStateFlow()

    private val _latestVideos = MutableStateFlow<List<Video>>(emptyList())
    val latestVideos: StateFlow<List<Video>> = _latestVideos.asStateFlow()

    private val _trendingContent = MutableStateFlow<List<Video>>(emptyList())
    val trendingContent: StateFlow<List<Video>> = _trendingContent.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    init {
        loadHomeContent()
    }

    private fun loadHomeContent() {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                videoRepository.getFeaturedContent().collect { result ->
                    result.onSuccess {
                        _featuredContent.value = it
                    }.onFailure {
                        _error.value = it.message
                    }
                }
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }

        viewModelScope.launch {
            try {
                videoRepository.getVideos().collect { result ->
                    result.onSuccess {
                        _latestVideos.value = it
                    }.onFailure {
                        _error.value = it.message
                    }
                }
            } catch (e: Exception) {
                _error.value = e.message
            }
        }

        viewModelScope.launch {
            try {
                videoRepository.getTrendingContent().collect { result ->
                    result.onSuccess {
                        _trendingContent.value = it
                    }.onFailure {
                        _error.value = it.message
                    }
                }
            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }
}
