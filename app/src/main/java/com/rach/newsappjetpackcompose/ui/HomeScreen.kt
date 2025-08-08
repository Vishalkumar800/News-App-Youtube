package com.rach.newsappjetpackcompose.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rach.newsappjetpackcompose.AppPreview
import com.rach.newsappjetpackcompose.theme.NewsAppJetPackComposeTheme
import com.rach.newsappjetpackcompose.ui.components.CustomTopAppBar

@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            CustomTopAppBar(
                title = "Home",
                modifier = Modifier.fillMaxWidth()
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ){

        }
    }
}


@AppPreview
@Composable
private fun Preview() {
    NewsAppJetPackComposeTheme {
        HomeScreen()
    }
}