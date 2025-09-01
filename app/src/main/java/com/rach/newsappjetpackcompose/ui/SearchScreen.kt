package com.rach.newsappjetpackcompose.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rach.newsappjetpackcompose.NewsState
import com.rach.newsappjetpackcompose.NewsViewModel
import com.rach.newsappjetpackcompose.ui.components.SingleArticleUi

@Composable
fun SearchScreen(viewModel: NewsViewModel) {
    val state by viewModel.searchNewsState.collectAsState()

    when (val result = state) {
        is NewsState.Empty -> {
            StateScreenHandle(
                modifier = Modifier.fillMaxSize(),
                text = "Click On Search Icon And Start Searching"
            )
        }

        is NewsState.Error -> {
            StateScreenHandle(
                modifier = Modifier.fillMaxSize(),
                text = "Error ${result.errorMessage}"
            )
        }

        is NewsState.Loading -> {
            StateHandleLoading(modifier = Modifier.fillMaxSize())
        }

        is NewsState.Success -> {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {

                items(result.data.articles){ data ->
                    SingleArticleUi(
                        article = data,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}

@Composable
fun StateScreenHandle(
    modifier: Modifier = Modifier, contentAlignment: Alignment = Alignment.Center,
    text: String
) {
    Box(
        modifier = modifier,
        contentAlignment = contentAlignment
    ) {
        Text(text = text)
    }
}

@Composable
fun StateHandleLoading(
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.Center
) {
    Box(
        modifier = modifier,
        contentAlignment = contentAlignment
    ) {
        CircularProgressIndicator()
    }
}