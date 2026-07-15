package com.smeonlinetv.app.data.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("profileImage")
    val profileImage: String?,
    @SerializedName("bio")
    val bio: String?,
    @SerializedName("joinDate")
    val joinDate: String,
    @SerializedName("subscriptionStatus")
    val subscriptionStatus: String,
    @SerializedName("watchHistory")
    val watchHistory: List<String> = emptyList()
)
