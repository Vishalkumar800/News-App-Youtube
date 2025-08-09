package com.rach.newsappjetpackcompose.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.rach.newsappjetpackcompose.AppPreview
import com.rach.newsappjetpackcompose.R
import com.rach.newsappjetpackcompose.model.Article
import com.rach.newsappjetpackcompose.model.Source
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
            LazyColumn {
                items(3){
                    SingleArticleUi(
                        article = Article(
                            title = stringResource(R.string.title),
                            description = stringResource(R.string.description),
                            source = Source(
                                name = "Aaj Tak"
                            ),
                            publishedAt = "12/3/2025"
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
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