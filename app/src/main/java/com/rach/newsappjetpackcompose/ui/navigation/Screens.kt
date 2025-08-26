package com.rach.newsappjetpackcompose.ui.navigation

sealed class Screens(val route: String) {
    object HomeScreen : Screens("Home")
    object SavedScreen : Screens("Saved Screen")
    object SearchScreen: Screens("Search Screen")
}

  