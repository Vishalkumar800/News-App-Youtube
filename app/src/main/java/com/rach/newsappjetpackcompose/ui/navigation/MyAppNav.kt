package com.rach.newsappjetpackcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rach.newsappjetpackcompose.ui.HomeScreen
import com.rach.newsappjetpackcompose.ui.SavedScreen
import com.rach.newsappjetpackcompose.ui.SearchScreen

@Composable
fun MyAppNav(navHostController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = Screens.HomeScreen.route
    ) {
        composable(Screens.HomeScreen.route) {
            HomeScreen()
        }
        composable(Screens.SavedScreen.route) {
            SavedScreen()
        }
        composable(Screens.SearchScreen.route) {
            SearchScreen()
        }
    }
}