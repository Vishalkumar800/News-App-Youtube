package com.rach.newsappjetpackcompose.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.rach.newsappjetpackcompose.NewsViewModel
import com.rach.newsappjetpackcompose.NewsViewModelFactory
import com.rach.newsappjetpackcompose.api.NewsRepositoryImp
import com.rach.newsappjetpackcompose.ui.components.BottomAppBarUi
import com.rach.newsappjetpackcompose.ui.components.CustomTopAppBar
import com.rach.newsappjetpackcompose.ui.navigation.MyAppNav
import com.rach.newsappjetpackcompose.ui.navigation.Screens

@Composable
fun RouteScreen() {

    val navHostController = rememberNavController()
    val backStackEntry by navHostController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    val viewModel: NewsViewModel = viewModel(
        factory = NewsViewModelFactory(newsRepository = NewsRepositoryImp())
    )


    Scaffold(
        topBar = {
            CustomTopAppBar(
                title = currentRoute,
                modifier = Modifier.fillMaxWidth(),
                userSearchQuery = { searchKeyWord ->
                    viewModel.getSearchNews(searchKeyWord)
                },
                onSearchIconClick = {
                    navHostController.navigate(Screens.SearchScreen.route)
                }
            )
        },
        bottomBar = {
            BottomAppBarUi(
                route = currentRoute,
                navHostController = navHostController,
                modifier = Modifier.fillMaxWidth()
            )
        }
    ) { paddingValues ->
        MyAppNav(
            navHostController = navHostController,
            modifier = Modifier.padding(paddingValues),
            viewModel = viewModel
        )
    }
}

