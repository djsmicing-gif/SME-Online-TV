package com.smeonlinetv.app.data.repository

import com.smeonlinetv.app.data.model.User

class UserRepository {
    fun getCurrentUser(): User {
        return User(
            id = "1",
            name = "John Doe",
            email = "john@example.com",
            profileImage = "https://via.placeholder.com/150x150?text=John",
            isVerified = true
        )
    }
    
    fun updateProfile(user: User): Boolean {
        return true
    }
}
