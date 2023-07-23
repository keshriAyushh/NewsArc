package com.ayush.newsarc.domain.repository

import com.ayush.newsarc.domain.model.top_healdines.Article

interface GetNewsArticleRepository {

    suspend fun getHeadlines(country: String): List<Article>
    suspend fun getSportsNews(): List<Article>
    suspend fun getGamingNews(): List<Article>
    suspend fun getPoliticalNews(): List<Article>
    suspend fun getTechNews(): List<Article>
    suspend fun getEducationNews(): List<Article>
    suspend fun getScienceNews(): List<Article>
    suspend fun getQueryRelatedNews(query: String): List<Article>
}