package com.rach.newsappjetpackcompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rach.newsappjetpackcompose.api.NewsRepository
import com.rach.newsappjetpackcompose.model.NewsResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class NewsState {
    object Loading : NewsState()
    data class Success(val data: NewsResponse) : NewsState()
    data class Error(val errorMessage: String) : NewsState()
    object Empty : NewsState()
}

class NewsViewModel(
    private val newsRepository: NewsRepository
) : ViewModel() {


    private val _breakingNewsState = MutableStateFlow<NewsState>(NewsState.Empty)
    val breakingNewsState: StateFlow<NewsState> = _breakingNewsState.asStateFlow()

    private val _searchNewsState = MutableStateFlow<NewsState>(NewsState.Empty)
    val searchNewsState: StateFlow<NewsState> = _searchNewsState.asStateFlow()

    init {
        getTopHeadLinedNews("us")
    }

    fun getTopHeadLinedNews(countryCode: String) {
        viewModelScope.launch {
            _breakingNewsState.value = NewsState.Loading
            try {
                val response = newsRepository.getTopHeadLinedNews(countryCode = countryCode)
                if (response.isSuccessful && response.body() != null) {
                    _breakingNewsState.value = NewsState.Success(response.body()!!)
                } else {
                    _breakingNewsState.value = NewsState.Error(response.message())
                }
            } catch (e: Exception) {
                _breakingNewsState.value =
                    NewsState.Error(e.localizedMessage ?: "Something Went Wrong")
            }
        }
    }

    fun getSearchNews(searchKeyWord: String) {
        viewModelScope.launch {
            _searchNewsState.value = NewsState.Loading
            try {
                val response = newsRepository.getSearchNews(searchKeyWord)
                if (response.isSuccessful && response.body() != null) {
                    _searchNewsState.value = NewsState.Success(response.body()!!)
                } else {
                    _searchNewsState.value = NewsState.Error(response.message())
                }
            } catch (e: Exception) {
                _searchNewsState.value =
                    NewsState.Error(e.localizedMessage ?: "Something went Wrong")
            }
        }
    }

}