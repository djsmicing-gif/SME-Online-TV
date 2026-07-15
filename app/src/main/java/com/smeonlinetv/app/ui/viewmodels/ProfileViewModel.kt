package com.smeonlinetv.app.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smeonlinetv.app.data.models.User
import com.smeonlinetv.app.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    private val _updateSuccess = MutableStateFlow(false)
    val updateSuccess: StateFlow<Boolean> = _updateSuccess.asStateFlow()

    init {
        loadUserProfile()
    }

    private fun loadUserProfile() {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                userRepository.getUserProfile().collect { result ->
                    result.onSuccess {
                        _user.value = it
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

    fun updateProfile(user: User) {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                userRepository.updateUserProfile(user).collect { result ->
                    result.onSuccess {
                        _user.value = it
                        _updateSuccess.value = true
                    }.onFailure {
                        _error.value = it.message
                        _updateSuccess.value = false
                    }
                }
            } catch (e: Exception) {
                _error.value = e.message
                _updateSuccess.value = false
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun clearUpdateSuccess() {
        _updateSuccess.value = false
    }
}
