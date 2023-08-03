package com.example.section20_mvvmcleanarchiteture.data.repository.dataSource

import com.example.section20_mvvmcleanarchiteture.data.model.Article
import kotlinx.coroutines.flow.Flow


interface NewsLocalDataSource {

    suspend fun insert(article: Article)

    fun getSavedNews(): Flow<List<Article>>

    suspend fun delete(article: Article)
}