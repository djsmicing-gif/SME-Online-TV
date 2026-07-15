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
class VideosViewModel @Inject constructor(
    private val videoRepository: VideoRepository
) : ViewModel() {

    private val _videos = MutableStateFlow<List<Video>>(emptyList())
    val videos: StateFlow<List<Video>> = _videos.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    private var currentPage = 1

    init {
        loadVideos()
    }

    private fun loadVideos() {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                videoRepository.getVideos(currentPage).collect { result ->
                    result.onSuccess {
                        _videos.value = if (currentPage == 1) it else _videos.value + it
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
    }

    fun loadMoreVideos() {
        currentPage++
        loadVideos()
    }

    fun refreshVideos() {
        currentPage = 1
        loadVideos()
    }

    fun filterByCategory(category: String) {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                videoRepository.getVideosByCategory(category).collect { result ->
                    result.onSuccess {
                        _videos.value = it
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
    }
}
