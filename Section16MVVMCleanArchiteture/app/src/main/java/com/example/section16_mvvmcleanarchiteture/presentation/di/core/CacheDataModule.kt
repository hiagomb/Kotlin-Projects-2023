package com.example.section16_mvvmcleanarchiteture.presentation.di.core

import com.example.section16_mvvmcleanarchiteture.data.repository.movie.dataSource.MovieCacheDataSource
import com.example.section16_mvvmcleanarchiteture.data.repository.movie.dataSourceImpl.MovieCacheDataSourceImpl
import com.example.section16_mvvmcleanarchiteture.data.repository.people.dataSource.PeopleCacheDataSource
import com.example.section16_mvvmcleanarchiteture.data.repository.people.dataSourceImpl.PeopleCacheDataSourceImpl
import com.example.section16_mvvmcleanarchiteture.data.repository.tvShow.dataSource.TvShowCacheDataSource
import com.example.section16_mvvmcleanarchiteture.data.repository.tvShow.dataSourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource{
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun providePeopleCacheDataSource(): PeopleCacheDataSource{
        return PeopleCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource{
        return TvShowCacheDataSourceImpl()
    }
}