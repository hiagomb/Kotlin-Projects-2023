package com.example.section20_mvvmcleanarchiteture.data.api

import com.example.section20_mvvmcleanarchiteture.BuildConfig
import com.example.section20_mvvmcleanarchiteture.data.model.TopHeadLinesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("v2/top-headlines")
    suspend fun getTopHeadLines(
        @Query("country") country: String,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String? = BuildConfig.API_KEY
    ): Response<TopHeadLinesResponse>


    @GET("v2/top-headlines")
    suspend fun getSearchedTopHeadLines(
        @Query("country") country: String,
        @Query("page") page: Int,
        @Query("q") query: String,
        @Query("apiKey") apiKey: String? = BuildConfig.API_KEY
    ): Response<TopHeadLinesResponse>
}