package com.ayush.newsarc.presentation.Screens.discover

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ayush.newsarc.R
import com.ayush.newsarc.domain.model.top_healdines.Article
import com.ayush.newsarc.presentation.DiscoverStateHolder
import com.ayush.newsarc.presentation.Screens.home.ArticleItem
import com.ayush.newsarc.presentation.viewmodel.DiscoverViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiscoverScreen(
    viewModel: DiscoverViewModel = hiltViewModel(),
    onItemClick: (String) -> Unit,
    navController: NavHostController
) {

    val searchQuery = rememberSaveable {
        mutableStateOf("")
    }

    var res = viewModel.articles.value
    Column(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(Color.White)
            .padding(15.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {

        LazyColumn(content = {
            item {
                Text(
                    text = "Discover",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.sans_bold)),
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "News from all around the world",
                    color = Color.Gray,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.sans_light)),
                    fontWeight = FontWeight.Normal
                )
                OutlinedTextField(
                    value = searchQuery.value,
                    onValueChange = {
                        searchQuery.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp)
                        .clip(RoundedCornerShape(2.dp)),
                    placeholder = {
                        Text(
                            text = "Search",
                            color = Color.Gray,
                            fontSize = 14.sp
                        )
                    },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "search_news",
                            tint = Color.Gray,
                            modifier = Modifier.clickable {
                                viewModel.getQueryRelatedNews(searchQuery.value)
                                res = viewModel.articles.value
                            }
                        )
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = Color.Black,
                        cursorColor = Color.Black,
                        unfocusedTrailingIconColor = Color.Gray,
                        focusedTrailingIconColor = Color.Blue,
                        containerColor = Color.Transparent,
                        focusedBorderColor = Color.Blue,
                        unfocusedBorderColor = Color.Gray
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Search
                    ),
                    visualTransformation = VisualTransformation.None
                )


                if (res.isLoading) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize(1f)
                    ) {
                        CircularProgressIndicator()
                    }
                } else if (res.error.isNotBlank()) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize(1f)
                    ) {
                        Text(
                            text = res.error
                        )
                    }

                }
            }
            res.data?.let {
                items(it) {

                    ArticleItem(
                        article = it,
                        Modifier.clickable { onItemClick(it.url) })
                    Spacer(
                        modifier = Modifier
                            .height(10.dp)
                            .background(Color.White)
                    )
                    Divider(
                        thickness = 0.5.dp,
                        color = Color.Gray
                    )
                    Spacer(
                        modifier = Modifier
                            .height(25.dp)
                            .background(Color.White)
                    )
                }
            }
        })
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    DiscoverScreen(
        onItemClick = {},
        navController = rememberNavController()
    )
}