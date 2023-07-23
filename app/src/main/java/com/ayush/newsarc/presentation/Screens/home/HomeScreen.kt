package com.ayush.newsarc.presentation.Screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ayush.newsarc.R
import com.ayush.newsarc.presentation.viewmodel.NewsViewModel

@Composable
fun HomeScreen(
    viewModel: NewsViewModel = hiltViewModel(),
    navController: NavHostController,
    onItemClick: (String) -> Unit
) {

    val res = viewModel.articles.value

    val searchQuery = rememberSaveable {
        mutableStateOf("")
    }

    if (res.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    } else if (res.error.isNotBlank()) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = res.error, modifier = Modifier.align(Alignment.Center))
        }
    } else {
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .background(Color.White)
                .padding(15.dp)
        ) {
            res.data?.let {
                LazyColumn(content = {
                    item {
                        Row(
                            verticalAlignment = Alignment.Top,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth(1f)
                                .background(Color.White)
                        ) {
                            Text(
                                text = "Top Headlines",
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily(Font(R.font.sans_bold)),
                                fontSize = 20.sp,
                                modifier = Modifier
                                    .fillMaxWidth(1f)
                                    .background(Color.White)
                            )
                        }
                        Spacer(modifier = Modifier
                            .height(15.dp)
                            .background(Color.White))
                    }
                    items(it) {
                        ArticleItem(article = it, Modifier.clickable { onItemClick(it.url) })
                        Spacer(modifier = Modifier.height(10.dp).background(Color.White))
                        Divider(
                            thickness = 0.5.dp,
                            color = Color.Gray
                        )
                        Spacer(modifier = Modifier.height(25.dp).background(Color.White))
                    }
                })
            }
        }

    }
}
