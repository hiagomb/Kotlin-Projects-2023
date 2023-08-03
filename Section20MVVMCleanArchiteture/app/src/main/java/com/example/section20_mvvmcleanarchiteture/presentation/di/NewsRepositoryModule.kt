package com.example.section20_mvvmcleanarchiteture.presentation.di

import com.example.section20_mvvmcleanarchiteture.data.repository.NewsRepositoryImpl
import com.example.section20_mvvmcleanarchiteture.data.repository.dataSource.NewsLocalDataSource
import com.example.section20_mvvmcleanarchiteture.data.repository.dataSource.NewsRemoteDataSource
import com.example.section20_mvvmcleanarchiteture.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NewsRepositoryModule {

    @Singleton
    @Provides
    fun providesNewsRepository(newsRemoteDataSource: NewsRemoteDataSource, newsLocalDataSource: NewsLocalDataSource): NewsRepository{
        return NewsRepositoryImpl(newsRemoteDataSource, newsLocalDataSource)
    }
}