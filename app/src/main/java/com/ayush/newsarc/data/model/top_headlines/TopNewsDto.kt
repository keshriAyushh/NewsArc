package com.ayush.newsarc.data.model.top_headlines

import com.ayush.newsarc.domain.model.top_healdines.TopNews

data class TopNewsDto(
    val articles: List<ArticleDto>,
    val status: String,
    val totalResults: Int
)

fun TopNewsDto.toTopNews() =
    TopNews(
        articles = articles.map { it.toArticle() }
    )
