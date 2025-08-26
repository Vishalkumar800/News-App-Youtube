package com.rach.newsappjetpackcompose.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.rach.newsappjetpackcompose.ui.components.BottomAppBarUi
import com.rach.newsappjetpackcompose.ui.components.CustomTopAppBar
import com.rach.newsappjetpackcompose.ui.navigation.MyAppNav

@Composable
fun RouteScreen() {

    val navHostController = rememberNavController()
    val backStackEntry by navHostController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    Scaffold(
        topBar = {
            CustomTopAppBar(
                title = currentRoute,
                modifier = Modifier.fillMaxWidth()
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
            modifier = Modifier.padding(paddingValues)
        )
    }
}

