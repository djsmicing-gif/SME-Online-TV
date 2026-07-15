package com.smeonlinetv.app.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smeonlinetv.app.data.models.News
import com.smeonlinetv.app.data.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    private val _news = MutableStateFlow<List<News>>(emptyList())
    val news: StateFlow<List<News>> = _news.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    private var currentPage = 1

    init {
        loadNews()
    }

    private fun loadNews() {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                newsRepository.getNews(currentPage).collect { result ->
                    result.onSuccess {
                        _news.value = if (currentPage == 1) it else _news.value + it
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

    fun loadMoreNews() {
        currentPage++
        loadNews()
    }

    fun refreshNews() {
        currentPage = 1
        loadNews()
    }

    fun filterByCategory(category: String) {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                newsRepository.getNewsByCategory(category).collect { result ->
                    result.onSuccess {
                        _news.value = it
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
