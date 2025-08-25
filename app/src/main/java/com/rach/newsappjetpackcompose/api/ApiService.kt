package com.rach.newsappjetpackcompose.api

import com.rach.newsappjetpackcompose.model.NewsResponse
import com.rach.newsappjetpackcompose.utils.K
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/top-headlines")
    suspend fun getTopHeadLinesNews(
        @Query("country")
        countryCode: String = "us",
        @Query("apiKey")
        apiKey: String = K.API_KEY
    ): Response<NewsResponse>

    @GET("v2/everything")
    suspend fun getSearchNews(
        @Query("q")
        searchKeyWord: String,
        @Query("apiKey")
        apiKey: String = K.API_KEY
    ): Response<NewsResponse>


}