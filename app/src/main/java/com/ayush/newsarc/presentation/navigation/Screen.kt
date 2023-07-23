package com.ayush.newsarc.presentation.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.ayush.newsarc.R

sealed class Screen(
    val route: String,
    val label: String,
    val icon: Int?
) {

    object Home: Screen("home", "Home", R.drawable.home)
    object Saved: Screen("saved", "Saved", R.drawable.save)
    object Discover: Screen("discover", "Discover", R.drawable.discover)
    object Web: Screen("news_detail", "Web", null)
}