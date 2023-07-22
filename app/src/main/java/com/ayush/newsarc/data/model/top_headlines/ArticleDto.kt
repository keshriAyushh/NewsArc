package com.ayush.newsarc.data.model.top_headlines

import com.ayush.newsarc.domain.model.top_healdines.Article

data class ArticleDto(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: SourceDto,
    val title: String,
    val url: String,
    val urlToImage: String
)

fun ArticleDto.toArticle() =
    Article(
        description = description,
        publishedAt = publishedAt,
        title = title,
        url = url,
        urlToImage = urlToImage
    )