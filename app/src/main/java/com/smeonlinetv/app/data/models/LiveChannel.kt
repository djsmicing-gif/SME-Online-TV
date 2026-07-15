package com.smeonlinetv.app.data.models

import com.google.gson.annotations.SerializedName

data class LiveChannel(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("streamUrl")
    val streamUrl: String,
    @SerializedName("isLive")
    val isLive: Boolean,
    @SerializedName("viewers")
    val viewers: Long,
    @SerializedName("category")
    val category: String
)
