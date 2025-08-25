package com.rach.newsappjetpackcompose

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.rach.newsappjetpackcompose.api.NewsRepository
import com.rach.newsappjetpackcompose.model.NewsResponse
import com.rach.newsappjetpackcompose.utils.MyApplication
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class NewsState {
    object Loading : NewsState()
    data class Success(val news: NewsResponse) : NewsState()
    data class Error(val errorMessage: String) : NewsState()
    object Empty : NewsState()
}

class NewsViewModel(
    application: MyApplication,
    private val newsRepository: NewsRepository
) : AndroidViewModel(application = application) {

    private val _breakingNewsState = MutableStateFlow<NewsState>(NewsState.Empty)
    val breakingNewsState: StateFlow<NewsState> = _breakingNewsState.asStateFlow()

    init {
        getTopHeadLineNews("us")
    }
    fun getTopHeadLineNews(countryCode: String) {
        viewModelScope.launch {
            _breakingNewsState.value = NewsState.Loading
            try {
                val response = newsRepository.getTopHeadLines(countryCode)

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
            _breakingNewsState.value = NewsState.Loading
            try {
                val response = newsRepository.getSearchNews(searchKeyWord)
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

}