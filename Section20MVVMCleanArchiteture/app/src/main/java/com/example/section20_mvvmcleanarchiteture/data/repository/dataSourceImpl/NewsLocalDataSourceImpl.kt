package com.example.section20_mvvmcleanarchiteture.data.repository.dataSourceImpl

import com.example.section20_mvvmcleanarchiteture.data.db.ArticleDao
import com.example.section20_mvvmcleanarchiteture.data.model.Article
import com.example.section20_mvvmcleanarchiteture.data.repository.dataSource.NewsLocalDataSource
import kotlinx.coroutines.flow.Flow

class NewsLocalDataSourceImpl(private val articleDao: ArticleDao): NewsLocalDataSource {


    override suspend fun insert(article: Article) {
        articleDao.insert(article)
    }

    override fun getSavedNews(): Flow<List<Article>> {
        return articleDao.getSavedNews()
    }

    override suspend fun delete(article: Article) {
        articleDao.delete(article)
    }
}