package com.example.section16_mvvmcleanarchiteture.presentation.di.core

import com.example.section16_mvvmcleanarchiteture.data.db.MovieDAO
import com.example.section16_mvvmcleanarchiteture.data.db.PeopleDAO
import com.example.section16_mvvmcleanarchiteture.data.db.TvShowDAO
import com.example.section16_mvvmcleanarchiteture.data.repository.movie.dataSource.MovieLocalDataSource
import com.example.section16_mvvmcleanarchiteture.data.repository.movie.dataSourceImpl.MovieLocalDataSourceImpl
import com.example.section16_mvvmcleanarchiteture.data.repository.people.dataSource.PeopleLocalDataSource
import com.example.section16_mvvmcleanarchiteture.data.repository.people.dataSourceImpl.PeopleLocalDataSourceImpl
import com.example.section16_mvvmcleanarchiteture.data.repository.tvShow.dataSource.TvShowLocalDataSource
import com.example.section16_mvvmcleanarchiteture.data.repository.tvShow.dataSourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDAO: MovieDAO): MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDAO)
    }

    @Singleton
    @Provides
    fun providePeopleLocalDataSource(peopleDAO: PeopleDAO): PeopleLocalDataSource{
        return PeopleLocalDataSourceImpl(peopleDAO)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDAO: TvShowDAO): TvShowLocalDataSource{
        return TvShowLocalDataSourceImpl(tvShowDAO)
    }
}