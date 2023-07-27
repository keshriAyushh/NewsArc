package com.ayush.newsarc.data.repository

import com.ayush.newsarc.data.remote.NewsApi
import com.ayush.newsarc.domain.model.top_healdines.Article
import com.ayush.newsarc.domain.repository.GetNewsArticleRepository
import com.ayush.newsarc.mappers.toDomain
import javax.inject.Inject

class GetNewsArticleRepositoryImpl @Inject constructor(
    private val newsApi: NewsApi,
) : GetNewsArticleRepository {
    override suspend fun getHeadlines(country: String): List<Article> {

        val response = newsApi.getHeadlines(country)
        return response.articles.toDomain()
    }


    override suspend fun getQueryRelatedNews(query: String): List<Article> {
        val response = newsApi.getQueryRelatedNews(query)
        return response.articles.toDomain()
    }


}