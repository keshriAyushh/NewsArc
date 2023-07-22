package com.ayush.newsarc.data.model.top_headlines

data class TopNewsDto(
    val articles: List<ArticleDto>,
    val status: String,
    val totalResults: Int
)