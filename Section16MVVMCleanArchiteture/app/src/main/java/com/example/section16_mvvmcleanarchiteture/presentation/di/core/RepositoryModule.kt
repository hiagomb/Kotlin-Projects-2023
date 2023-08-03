package com.example.section16_mvvmcleanarchiteture.presentation.di.core

import com.example.section16_mvvmcleanarchiteture.data.repository.movie.MovieRepositoryImpl
import com.example.section16_mvvmcleanarchiteture.data.repository.movie.dataSource.MovieCacheDataSource
import com.example.section16_mvvmcleanarchiteture.data.repository.movie.dataSource.MovieLocalDataSource
import com.example.section16_mvvmcleanarchiteture.data.repository.movie.dataSource.MovieRemoteDataSource
import com.example.section16_mvvmcleanarchiteture.data.repository.people.PeopleRepositoryImpl
import com.example.section16_mvvmcleanarchiteture.data.repository.people.dataSource.PeopleCacheDataSource
import com.example.section16_mvvmcleanarchiteture.data.repository.people.dataSource.PeopleLocalDataSource
import com.example.section16_mvvmcleanarchiteture.data.repository.people.dataSource.PeopleRemoteDataSource
import com.example.section16_mvvmcleanarchiteture.data.repository.tvShow.TvShowRepositoryImpl
import com.example.section16_mvvmcleanarchiteture.data.repository.tvShow.dataSource.TvShowCacheDataSource
import com.example.section16_mvvmcleanarchiteture.data.repository.tvShow.dataSource.TvShowLocalDataSource
import com.example.section16_mvvmcleanarchiteture.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import com.example.section16_mvvmcleanarchiteture.domain.repository.MovieRepository
import com.example.section16_mvvmcleanarchiteture.domain.repository.PeopleRepository
import com.example.section16_mvvmcleanarchiteture.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(movieRemoteDataSource: MovieRemoteDataSource,
                               movieLocalDataSource: MovieLocalDataSource,
                               movieCacheDataSource: MovieCacheDataSource): MovieRepository{

        return MovieRepositoryImpl(movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource)
    }

    @Singleton
    @Provides
    fun providePeopleRepository(peopleRemoteDataSource: PeopleRemoteDataSource,
                               peopleLocalDataSource: PeopleLocalDataSource,
                               peopleCacheDataSource: PeopleCacheDataSource): PeopleRepository{

        return PeopleRepositoryImpl(peopleCacheDataSource,
            peopleLocalDataSource, peopleRemoteDataSource)
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(tvShowRemoteDataSource: TvShowRemoteDataSource,
                               tvShowLocalDataSource: TvShowLocalDataSource,
                               tvShowCacheDataSource: TvShowCacheDataSource): TvShowRepository{

        return TvShowRepositoryImpl(tvShowRemoteDataSource,
            tvShowLocalDataSource, tvShowCacheDataSource)
    }
}