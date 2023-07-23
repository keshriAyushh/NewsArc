package com.ayush.newsarc.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.ayush.newsarc.data.remote.NewsApi
import com.ayush.newsarc.presentation.Screens.HomeScreen
import com.ayush.newsarc.presentation.navigation.Navigation
import com.ayush.newsarc.presentation.ui.theme.NewsArcTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var newsApi: NewsApi
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        CoroutineScope(Dispatchers.IO).launch {
//            val response = newsApi.getHeadlines("in")
//            Log.d("Tag", response.articles.toString())
//        }
        setContent {
            NewsArcTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(1f),
                    color = Color.White
                ) {
                    Navigation()

                }

            }
        }
    }
}
