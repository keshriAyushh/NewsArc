package com.ayush.newsarc.mappers

import com.ayush.newsarc.data.model.top_headlines.ArticleDto
import com.ayush.newsarc.domain.model.top_healdines.Article

fun List<ArticleDto>.toDomain(): List<Article> {
    return map{
        Article(
            description = it.description?:"",
            title = it.title?:"",
            urlToImage = it.urlToImage?:"",
            url = it.url?:"",
            publishedAt = it.publishedAt?:""
        )
    }
}