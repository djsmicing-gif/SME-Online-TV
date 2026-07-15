package com.smeonlinetv.app.data.repository

import com.smeonlinetv.app.data.model.NewsArticle

class NewsRepository {
    fun getAllNews(): List<NewsArticle> {
        return listOf(
            NewsArticle(
                id = "1",
                title = "Breaking News 1",
                description = "This is the description for news 1",
                imageUrl = "https://via.placeholder.com/400x225?text=News+1",
                publishedAt = "2024-01-15",
                content = "Full content for news 1"
            ),
            NewsArticle(
                id = "2",
                title = "Breaking News 2",
                description = "This is the description for news 2",
                imageUrl = "https://via.placeholder.com/400x225?text=News+2",
                publishedAt = "2024-01-14",
                content = "Full content for news 2"
            )
        )
    }
    
    fun searchNews(query: String): List<NewsArticle> {
        return getAllNews().filter { it.title.contains(query, ignoreCase = true) }
    }
}
