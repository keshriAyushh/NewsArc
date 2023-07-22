package com.ayush.newsarc.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ayush.newsarc.core.Resource
import com.ayush.newsarc.domain.use_case.GetTopHeadlinesUseCase
import com.ayush.newsarc.presentation.HomeStateHolder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val geTopHeadlinesUseCase: GetTopHeadlinesUseCase
): ViewModel(){

    val articles = mutableStateOf(HomeStateHolder())

    init {
        getTopHeadlines()
    }
    fun getTopHeadlines() {
        geTopHeadlinesUseCase().onEach {
            when(it) {
                is Resource.Loading -> {
                    articles.value = HomeStateHolder(isLoading = true)
                }
                is Resource.Success -> {
                    articles.value = HomeStateHolder(data = it.data)
                }
                is Resource.Error -> {
                    articles.value = HomeStateHolder(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }
}