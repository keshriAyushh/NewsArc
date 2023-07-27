package com.ayush.newsarc.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ayush.newsarc.core.Resource
import com.ayush.newsarc.domain.use_case.discover_use_case.GetDiscoverUseCase
import com.ayush.newsarc.presentation.DiscoverStateHolder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DiscoverViewModel @Inject constructor(
    private val getDiscoverUseCase: GetDiscoverUseCase
): ViewModel() {

    val articles = mutableStateOf(DiscoverStateHolder())

    fun getQueryRelatedNews(query: String) {
        getDiscoverUseCase(query).onEach {
            when(it) {
                is Resource.Error -> articles.value = DiscoverStateHolder(error = it.message.toString())
                is Resource.Loading -> articles.value = DiscoverStateHolder(isLoading = true)
                is Resource.Success -> articles.value = DiscoverStateHolder(data = it.data)
            }
        }.launchIn(viewModelScope)
    }
}