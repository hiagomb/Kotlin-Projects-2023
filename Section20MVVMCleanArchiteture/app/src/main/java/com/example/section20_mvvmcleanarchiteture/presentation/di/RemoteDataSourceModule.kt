package com.example.section20_mvvmcleanarchiteture.presentation.di

import com.example.section20_mvvmcleanarchiteture.data.api.NewsApiService
import com.example.section20_mvvmcleanarchiteture.data.repository.dataSource.NewsRemoteDataSource
import com.example.section20_mvvmcleanarchiteture.data.repository.dataSourceImpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RemoteDataSourceModule {


    @Singleton
    @Provides
    fun providesRemoteDataSource(newsApiService: NewsApiService): NewsRemoteDataSource{
        return NewsRemoteDataSourceImpl(newsApiService)
    }

}