package com.rach.newsappjetpackcompose.api

import com.rach.newsappjetpackcompose.model.NewsResponse
import retrofit2.Response

class NewsRepositoryImp : NewsRepository {
    override suspend fun getTopHeadLines(countryCode: String): Response<NewsResponse> {
        return RetrofitInstance().api.getTopHeadLinesNews(countryCode = countryCode)
    }

    override suspend fun getSearchNews(searchKey: String): Response<NewsResponse> {
        return RetrofitInstance().api.getSearchNews(searchKeyWord = searchKey)
    }

}