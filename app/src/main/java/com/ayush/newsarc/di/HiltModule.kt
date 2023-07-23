package com.ayush.newsarc.di

import com.ayush.newsarc.core.Constants
import com.ayush.newsarc.data.remote.NewsApi
import com.ayush.newsarc.data.repository.GetNewsArticleRepositoryImpl
import com.ayush.newsarc.domain.repository.GetNewsArticleRepository
import com.ayush.newsarc.domain.use_case.GetDiscoverUseCase
import com.ayush.newsarc.domain.use_case.GetTopHeadlinesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Singleton
    @Provides
    fun providesRetrofit() = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun providesNewsApi() = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NewsApi::class.java)

    @Singleton
    @Provides
    fun providesGetNewsRepository(newsApi: NewsApi): GetNewsArticleRepository {
        return GetNewsArticleRepositoryImpl(newsApi = newsApi)
    }

    @Singleton
    @Provides
    fun providesGetTopHeadlinesUseCase(newsArticleRepository: GetNewsArticleRepository): GetTopHeadlinesUseCase {
        return GetTopHeadlinesUseCase(newsArticleRepository)
    }

    @Singleton
    @Provides
    fun providesGetDiscoverUser(newsArticleRepository: GetNewsArticleRepository): GetDiscoverUseCase {
        return GetDiscoverUseCase(newsArticleRepository)
    }
}