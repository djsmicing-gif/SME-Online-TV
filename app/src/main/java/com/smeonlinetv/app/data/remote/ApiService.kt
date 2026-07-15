package com.smeonlinetv.app.data.remote

import com.smeonlinetv.app.data.models.ApiResponse
import com.smeonlinetv.app.data.models.LiveChannel
import com.smeonlinetv.app.data.models.News
import com.smeonlinetv.app.data.models.SearchResult
import com.smeonlinetv.app.data.models.User
import com.smeonlinetv.app.data.models.Video
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    // Videos
    @GET("/api/videos")
    suspend fun getVideos(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 20
    ): ApiResponse<List<Video>>

    @GET("/api/videos/{videoId}")
    suspend fun getVideoDetail(
        @Path("videoId") videoId: String
    ): ApiResponse<Video>

    @GET("/api/videos/category/{category}")
    suspend fun getVideosByCategory(
        @Path("category") category: String,
        @Query("page") page: Int = 1
    ): ApiResponse<List<Video>>

    // Live Channels
    @GET("/api/channels")
    suspend fun getLiveChannels(): ApiResponse<List<LiveChannel>>

    @GET("/api/channels/{channelId}")
    suspend fun getChannelDetail(
        @Path("channelId") channelId: String
    ): ApiResponse<LiveChannel>

    @GET("/api/channels/live")
    suspend fun getLiveChannels(
        @Query("category") category: String? = null
    ): ApiResponse<List<LiveChannel>>

    // News
    @GET("/api/news")
    suspend fun getNews(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 20
    ): ApiResponse<List<News>>

    @GET("/api/news/{newsId}")
    suspend fun getNewsDetail(
        @Path("newsId") newsId: String
    ): ApiResponse<News>

    @GET("/api/news/category/{category}")
    suspend fun getNewsByCategory(
        @Path("category") category: String,
        @Query("page") page: Int = 1
    ): ApiResponse<List<News>>

    // Search
    @GET("/api/search")
    suspend fun search(
        @Query("q") query: String,
        @Query("type") type: String? = null
    ): ApiResponse<List<SearchResult>>

    // User Profile
    @GET("/api/user/profile")
    suspend fun getUserProfile(): ApiResponse<User>

    @POST("/api/user/profile/update")
    suspend fun updateUserProfile(
        body: User
    ): ApiResponse<User>

    @GET("/api/user/watchhistory")
    suspend fun getWatchHistory(): ApiResponse<List<Video>>

    @POST("/api/user/watchhistory/{videoId}")
    suspend fun addToWatchHistory(
        @Path("videoId") videoId: String
    ): ApiResponse<String>

    // Featured Content
    @GET("/api/featured")
    suspend fun getFeaturedContent(): ApiResponse<List<Video>>

    // Trending
    @GET("/api/trending")
    suspend fun getTrendingContent(
        @Query("type") type: String? = null
    ): ApiResponse<List<Video>>
}
