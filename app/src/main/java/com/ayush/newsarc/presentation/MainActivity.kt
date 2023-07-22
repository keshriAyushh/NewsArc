package com.ayush.newsarc.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.ayush.newsarc.core.Constants
import com.ayush.newsarc.data.remote.NewsApi
import com.ayush.newsarc.domain.model.top_healdines.Article
import com.ayush.newsarc.presentation.Screens.ArticleItem
import com.ayush.newsarc.presentation.Screens.HomeScreen
import com.ayush.newsarc.presentation.ui.theme.NewsArcTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var newsApi: NewsApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        CoroutineScope(Dispatchers.IO).launch {
//            val response = newsApi.getHeadlines("in")
//            Log.d("Tag", response.articles.toString())
//        }
        setContent {
            NewsArcTheme {
                Surface(
                    modifier  = Modifier.fillMaxSize(1f),
                    color = Color.White
                ) {
                    HomeScreen()
                }
            }
        }
    }
}
