package com.ayush.newsarc.domain.use_case

import android.util.Log
import com.ayush.newsarc.core.Resource
import com.ayush.newsarc.domain.model.top_healdines.Article
import com.ayush.newsarc.domain.repository.GetNewsArticleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetTopHeadlinesUseCase @Inject constructor(
    private val getNewsArticleRepository: GetNewsArticleRepository
) {

    operator fun invoke(): Flow<Resource<List<Article>>> = flow {

        try {
            emit(Resource.Loading())
            val data = getNewsArticleRepository.getHeadlines("in")
            emit(Resource.Success(data))

        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage))
        }
    }
}