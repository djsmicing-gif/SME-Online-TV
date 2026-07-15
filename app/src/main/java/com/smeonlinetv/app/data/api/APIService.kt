package com.smeonlinetv.app.data.api

import retrofit2.http.GET
import retrofit2.http.Query
import com.smeonlinetv.app.data.model.Channel
import com.smeonlinetv.app.data.model.Video
import com.smeonlinetv.app.data.model.NewsArticle

interface APIService {
    @GET("channels")
    suspend fun getChannels(): List<Channel>
    
    @GET("channels/search")
    suspend fun searchChannels(@Query("q") query: String): List<Channel>
    
    @GET("videos")
    suspend fun getVideos(): List<Video>
    
    @GET("videos/search")
    suspend fun searchVideos(@Query("q") query: String): List<Video>
    
    @GET("news")
    suspend fun getNews(): List<NewsArticle>
    
    @GET("news/search")
    suspend fun searchNews(@Query("q") query: String): List<NewsArticle>
}
