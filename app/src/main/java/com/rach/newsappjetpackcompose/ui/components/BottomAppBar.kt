package com.rach.newsappjetpackcompose.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.savedstate.savedState
import com.rach.newsappjetpackcompose.ui.navigation.Screens

@Composable
fun BottomAppBarUi(
    route: String?,
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavigationBar(modifier = modifier) {
        BottomAppBarItem().bottomAppBarItems().forEach { item ->
            NavigationBarItem(
                selected = route == item.route,
                icon = {
                    Icon(
                        item.icon,
                        contentDescription = "BottomBar Icon"
                    )
                },
                label = {
                    Text(
                        text = item.title
                    )
                },
                onClick = {
                    navHostController.navigate(item.route) {
                        launchSingleTop = true
                        savedState { true }
                    }
                }
            )
        }
    }
}

data class BottomAppBarItem(
    val icon: ImageVector = Icons.Default.Home,
    val title: String = "",
    val route: String = ""
) {
    fun bottomAppBarItems(): List<BottomAppBarItem> {
        return listOf(
            BottomAppBarItem(
                title = "Home Screen",
                icon = Icons.Default.Home,
                route = Screens.HomeScreen.route
            ),
            BottomAppBarItem(
                title = "Saved Screen",
                icon = Icons.Default.Favorite,
                route = Screens.SavedScreen.route
            ),
            BottomAppBarItem(
                title = "Search Screen",
                icon = Icons.Default.Search,
                route = Screens.SearchScreen.route
            )
        )
    }
}