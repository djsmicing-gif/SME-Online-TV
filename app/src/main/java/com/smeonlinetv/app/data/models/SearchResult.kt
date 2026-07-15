package com.smeonlinetv.app.data.models

import com.google.gson.annotations.SerializedName

data class SearchResult(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("type")
    val type: String, // "video", "news", "channel"
    @SerializedName("url")
    val url: String?
)
