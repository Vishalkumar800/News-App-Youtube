package com.rach.newsappjetpackcompose.api

import com.rach.newsappjetpackcompose.model.NewsResponse
import retrofit2.Response

interface NewsRepository {

    suspend fun getTopHeadLinedNews(countryCode: String): Response<NewsResponse>
    suspend fun getSearchNews(searchKeyWord: String): Response<NewsResponse>

}