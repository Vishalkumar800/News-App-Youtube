package com.rach.newsappjetpackcompose.api

import com.rach.newsappjetpackcompose.model.NewsResponse
import retrofit2.Response

interface NewsRepository {
    suspend fun getTopHeadLines(countryCode: String): Response<NewsResponse>
    suspend fun getSearchNews(searchKey: String): Response<NewsResponse>
}