package com.example.section16_mvvmcleanarchiteture.presentation.di.core

import com.example.section16_mvvmcleanarchiteture.data.api.TMDBService
import com.example.section16_mvvmcleanarchiteture.data.repository.movie.dataSource.MovieRemoteDataSource
import com.example.section16_mvvmcleanarchiteture.data.repository.movie.dataSourceImpl.MovieRemoteDataSourceImpl
import com.example.section16_mvvmcleanarchiteture.data.repository.people.dataSource.PeopleRemoteDataSource
import com.example.section16_mvvmcleanarchiteture.data.repository.people.dataSourceImpl.PeopleRemoteDataSourceImpl
import com.example.section16_mvvmcleanarchiteture.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import com.example.section16_mvvmcleanarchiteture.data.repository.tvShow.dataSourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {


    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource{
        return TvShowRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun providePeopleRemoteDataSource(tmdbService: TMDBService): PeopleRemoteDataSource{
        return PeopleRemoteDataSourceImpl(tmdbService, apiKey)
    }
}