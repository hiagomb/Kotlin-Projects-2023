package com.example.section20_mvvmcleanarchiteture.presentation.di

import com.example.section20_mvvmcleanarchiteture.data.db.ArticleDao
import com.example.section20_mvvmcleanarchiteture.data.repository.dataSource.NewsLocalDataSource
import com.example.section20_mvvmcleanarchiteture.data.repository.dataSourceImpl.NewsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class LocalDataSourceModule {


    @Singleton
    @Provides
    fun providesLocalDataSource(articleDao: ArticleDao): NewsLocalDataSource{
        return NewsLocalDataSourceImpl(articleDao)
    }
}