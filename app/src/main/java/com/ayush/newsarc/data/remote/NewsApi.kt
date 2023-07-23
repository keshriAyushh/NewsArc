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
        @Query("sortBy") sortBy: String = "popularity",
        @Query("apiKey") apiKey: String = Constants.API_KEY,
        @Query("pageSize") pageSize: Int = 100
    ): TopNewsDto

    @GET("everything")
    suspend fun getPoliticalNews(
        @Query("q") query: String = "politics",
        @Query("sortBy") sortBy: String = "popularity",
        @Query("apiKey") apiKey: String = Constants.API_KEY,
    ): TopNewsDto

    @GET("everything")
    suspend fun getSportsNews(
        @Query("q") query: String = "sport",
        @Query("sortBy") sortBy: String = "popularity",
        @Query("apiKey") apiKey: String = Constants.API_KEY,
    ): TopNewsDto

    @GET("everything")
    suspend fun getEducationNews(
        @Query("q") query: String = "education",
        @Query("sortBy") sortBy: String = "popularity",
        @Query("apiKey") apiKey: String = Constants.API_KEY,
    ): TopNewsDto

    @GET("everything")
    suspend fun getGamingNews(
        @Query("q") query: String = "gaming",
        @Query("sortBy") sortBy: String = "popularity",
        @Query("apiKey") apiKey: String = Constants.API_KEY,
    ): TopNewsDto

    @GET("everything")
    suspend fun getTechNews(
        @Query("q") query: String = "tech",
        @Query("sortBy") sortBy: String = "popularity",
        @Query("apiKey") apiKey: String = Constants.API_KEY,
    ): TopNewsDto

    @GET("everything")
    suspend fun getScienceNews(
        @Query("q") query: String = "science",
        @Query("sortBy") sortBy: String = "popularity",
        @Query("apiKey") apiKey: String = Constants.API_KEY,
    ): TopNewsDto

    @GET("everything")
    suspend fun getQueryRelatedNews(
        @Query("q") query: String,
        @Query("sortBy") sortBy: String = "popularity",
        @Query("apiKey") apiKey: String = Constants.API_KEY
    ): TopNewsDto


}