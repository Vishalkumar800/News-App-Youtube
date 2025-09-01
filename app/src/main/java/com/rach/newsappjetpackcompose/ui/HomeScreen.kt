package com.rach.newsappjetpackcompose.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rach.newsappjetpackcompose.NewsState
import com.rach.newsappjetpackcompose.NewsViewModel
import com.rach.newsappjetpackcompose.NewsViewModelFactory
import com.rach.newsappjetpackcompose.api.NewsRepositoryImp

@Composable
fun HomeScreen(
    viewModel: NewsViewModel = viewModel(
        factory = NewsViewModelFactory(newsRepository = NewsRepositoryImp())
    )
) {

    val state = viewModel.breakingNewsState.collectAsState()

    when (val result = state.value) {
        is NewsState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is NewsState.Empty -> {
            Text("No data Fount")
        }

        is NewsState.Error -> {
            Text("Error Found ${result.errorMessage} ")
        }

        is NewsState.Success -> {

            LazyColumn {
                items(result.data.articles) { data ->
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