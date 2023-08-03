package com.example.section20_mvvmcleanarchiteture.domain.repository

import com.example.section20_mvvmcleanarchiteture.data.model.Article
import com.example.section20_mvvmcleanarchiteture.data.model.TopHeadLinesResponse
import com.example.section20_mvvmcleanarchiteture.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun getNewsHeadlines(country: String, page: Int): Resource<TopHeadLinesResponse>
    suspend fun getSearchedNews(country: String, page: Int, query: String): Resource<TopHeadLinesResponse>
    suspend fun saveNews(article: Article)
    suspend fun deleteNews(article: Article)
    fun getSavedNews(): Flow<List<Article>>

}