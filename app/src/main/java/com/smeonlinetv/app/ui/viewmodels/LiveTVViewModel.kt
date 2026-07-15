package com.smeonlinetv.app.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smeonlinetv.app.data.models.LiveChannel
import com.smeonlinetv.app.data.repository.LiveChannelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LiveTVViewModel @Inject constructor(
    private val liveChannelRepository: LiveChannelRepository
) : ViewModel() {

    private val _liveChannels = MutableStateFlow<List<LiveChannel>>(emptyList())
    val liveChannels: StateFlow<List<LiveChannel>> = _liveChannels.asStateFlow()

    private val _selectedChannel = MutableStateFlow<LiveChannel?>(null)
    val selectedChannel: StateFlow<LiveChannel?> = _selectedChannel.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    init {
        loadLiveChannels()
    }

    private fun loadLiveChannels() {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                liveChannelRepository.getLiveChannels().collect { result ->
                    result.onSuccess {
                        _liveChannels.value = it
                        if (it.isNotEmpty()) {
                            _selectedChannel.value = it.first()
                        }
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

    fun selectChannel(channel: LiveChannel) {
        _selectedChannel.value = channel
    }

    fun refreshChannels() {
        loadLiveChannels()
    }
}
