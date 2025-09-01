package com.rach.newsappjetpackcompose.api

import com.rach.newsappjetpackcompose.model.NewsResponse
import retrofit2.Response

class NewsRepositoryImp : NewsRepository {
    override suspend fun getTopHeadLinedNews(countryCode: String): Response<NewsResponse> {
        return RetrofitInstances().api.getTopHeadLinesNews(countryCode)
    }

    override suspend fun getSearchNews(searchKeyWord: String): Response<NewsResponse> {
        return RetrofitInstances().api.getSearchNews(searchKeyWord = searchKeyWord)
    }
}