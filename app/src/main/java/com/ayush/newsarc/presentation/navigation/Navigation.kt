package com.ayush.newsarc.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ayush.newsarc.R
import com.ayush.newsarc.presentation.Screens.discover.DiscoverScreen
import com.ayush.newsarc.presentation.Screens.home.HomeScreen
import com.ayush.newsarc.presentation.Screens.saved.SavedScreen
import com.ayush.newsarc.presentation.Screens.web.WebScreen
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation() {

    val navController = rememberNavController()

    val items = listOf(
        Screen.Home,
        Screen.Discover,
        Screen.Saved
    )

    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color.White
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route


                items.forEach {
                    BottomNavigationItem(
                        selected = currentRoute == it.route,
                        label = {
                            Text(
                                text = it.label,
                                fontFamily = FontFamily(Font(R.font.sans_reg)),
                                color = if(currentRoute == it.route) Color.Blue else Color.Black,
                                fontSize = 12.sp,
                                fontWeight = if(currentRoute == it.route) FontWeight.Bold else FontWeight.Normal
                            )
                        },
                        selectedContentColor = Color.Blue,
                        unselectedContentColor = Color.Black,
                        alwaysShowLabel = false,
                        icon = {
                            Icon(
                                painter = painterResource(it.icon!!),
                                contentDescription = null,
                                tint = if (currentRoute == it.route) Color.Blue else Color.Black
                            )
                        },
                        onClick = {
                            if(currentRoute != it.route) {
                                navController.graph.startDestinationRoute?.let {
                                    navController.popBackStack(it,true)
                                }
                            }
                            navController.navigate(it.route) {
                                launchSingleTop = true
                            }
                        }
                    )
                }
            }
        }
    ) {
        NavigationController(navController = navController)
    }
}
@Composable
fun NavigationController(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navController = navController, onItemClick = {url->
                val encodedUrl = URLEncoder.encode(url, StandardCharsets.UTF_8.toString())
                navController.navigate("news_detail/$encodedUrl")
            })
        }

        composable(Screen.Discover.route) {
            DiscoverScreen(navController = navController, onItemClick = {url ->
                val encodedUrl = URLEncoder.encode(url, StandardCharsets.UTF_8.toString())
                navController.navigate("news_detail/$encodedUrl")
            })
        }
        composable(Screen.Saved.route) {
            SavedScreen()
        }

        composable(
            route = "news_detail/{news_url}",
            arguments = listOf(
                navArgument("news_url") {
                    type = NavType.StringType
                    nullable = true
                    defaultValue = ""
                }
            )
        ) {
            val url = it.arguments?.getString("news_url") ?: ""
            WebScreen(url = url)
        }
    }
}