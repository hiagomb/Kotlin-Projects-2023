package com.example.section20_mvvmcleanarchiteture.data.repository.dataSourceImpl

import com.example.section20_mvvmcleanarchiteture.data.api.NewsApiService
import com.example.section20_mvvmcleanarchiteture.data.model.TopHeadLinesResponse
import com.example.section20_mvvmcleanarchiteture.data.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(private val newsApiService: NewsApiService): NewsRemoteDataSource {


    override suspend fun getNewsRemote(country: String, page: Int): Response<TopHeadLinesResponse> {
        return newsApiService.getTopHeadLines(country, page)
    }

    override suspend fun getSearchedNewsRemote(
        country: String,
        page: Int,
        query: String
    ): Response<TopHeadLinesResponse> {
        return newsApiService.getSearchedTopHeadLines(country, page, query)
    }
}