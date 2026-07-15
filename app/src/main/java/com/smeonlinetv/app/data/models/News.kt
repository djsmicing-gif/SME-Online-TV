package com.smeonlinetv.app.data.models

import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("author")
    val author: String,
    @SerializedName("publishDate")
    val publishDate: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("readTime")
    val readTime: Int
)
