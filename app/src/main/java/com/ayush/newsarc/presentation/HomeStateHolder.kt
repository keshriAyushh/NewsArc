package com.ayush.newsarc.presentation

import com.ayush.newsarc.domain.model.top_healdines.Article

data class HomeStateHolder(
    val isLoading: Boolean = false,
    val data: List<Article>? = null,
    val error: String = ""
)
