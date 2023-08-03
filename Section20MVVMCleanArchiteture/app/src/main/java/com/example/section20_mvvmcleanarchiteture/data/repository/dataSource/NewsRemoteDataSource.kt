package com.example.section20_mvvmcleanarchiteture.data.repository.dataSource

import com.example.section20_mvvmcleanarchiteture.data.model.TopHeadLinesResponse
import retrofit2.Response

interface NewsRemoteDataSource {

    suspend fun getNewsRemote(country: String, page: Int): Response<TopHeadLinesResponse>

    suspend fun getSearchedNewsRemote(country: String, page: Int, query: String): Response<TopHeadLinesResponse>

}