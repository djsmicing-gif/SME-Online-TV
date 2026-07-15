package com.smeonlinetv.app.data.models

import com.google.gson.annotations.SerializedName

data class Video(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("duration")
    val duration: Long,
    @SerializedName("views")
    val views: Long,
    @SerializedName("uploadDate")
    val uploadDate: String,
    @SerializedName("category")
    val category: String
)
