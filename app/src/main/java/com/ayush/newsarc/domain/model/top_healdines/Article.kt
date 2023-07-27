package com.ayush.newsarc.domain.model.top_healdines

data class Article(
    val description: String,
    val publishedAt: String,
    val title: String,
    val url: String,
    val urlToImage: String,
    val isSaved: Boolean = false
)
