package com.ayush.newsarc.domain.repository

import com.ayush.newsarc.domain.model.top_healdines.Article

interface GetNewsArticleRepository {

    suspend fun getHeadlines(country: String): List<Article>
    suspend fun getQueryRelatedNews(query: String): List<Article>
}