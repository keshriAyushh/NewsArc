package com.ayush.newsarc.domain.use_case.discover_use_case

import com.ayush.newsarc.core.Resource
import com.ayush.newsarc.domain.model.top_healdines.Article
import com.ayush.newsarc.domain.repository.GetNewsArticleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetDiscoverUseCase @Inject constructor(
    private val getNewsArticleRepository: GetNewsArticleRepository,
) {
    operator fun invoke(query: String): Flow<Resource<List<Article>>> = flow {
        getNewsArticleRepository.getQueryRelatedNews(query)
        try {
            emit(Resource.Loading())
            val data = getNewsArticleRepository.getQueryRelatedNews(query)
            emit(Resource.Success(data))

        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage))
        }
    }
}