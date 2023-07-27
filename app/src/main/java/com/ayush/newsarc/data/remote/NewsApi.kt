package com.ayush.newsarc.data.remote

import com.ayush.newsarc.core.Constants
import com.ayush.newsarc.data.model.top_headlines.TopNewsDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NewsApi {

    @GET("top-headlines")
    suspend fun getHeadlines(
        @Query("country") country: String,
        @Query("sortBy") sortBy: String = "relevancy",
        @Query("language") language: String = "en",
        @Query("apiKey") apiKey: String = Constants.API_KEY,
        @Query("pageSize") pageSize: Int = 100
    ): TopNewsDto
    @GET("everything")
    suspend fun getQueryRelatedNews(
        @Query("q") query: String,
        @Query("sortBy") sortBy: String = "relevancy",
        @Query("language") language: String = "en",
        @Query("apiKey") apiKey: String = Constants.API_KEY
    ): TopNewsDto


}