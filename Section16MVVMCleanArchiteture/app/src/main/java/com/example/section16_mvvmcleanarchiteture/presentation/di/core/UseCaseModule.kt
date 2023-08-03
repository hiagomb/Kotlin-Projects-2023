package com.example.section16_mvvmcleanarchiteture.presentation.di.core

import com.example.section16_mvvmcleanarchiteture.domain.repository.MovieRepository
import com.example.section16_mvvmcleanarchiteture.domain.repository.PeopleRepository
import com.example.section16_mvvmcleanarchiteture.domain.repository.TvShowRepository
import com.example.section16_mvvmcleanarchiteture.domain.usecase.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {


    @Provides
    fun provideGetMoviesUseCase(movieRepository: MovieRepository): GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }


    @Provides
    fun provideUpdateMoviesUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase{
        return UpdateMoviesUseCase(movieRepository)
    }


    @Provides
    fun provideGetPeopleUseCase(peopleRepository: PeopleRepository): GetPeopleUseCase{
        return GetPeopleUseCase(peopleRepository)
    }


    @Provides
    fun provideUpdatePeopleUseCase(peopleRepository: PeopleRepository): UpdatePeopleUseCase{
        return UpdatePeopleUseCase(peopleRepository)
    }


    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository): GetTvShowUseCase{
        return GetTvShowUseCase(tvShowRepository)
    }


    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository): UpdateTvShowUseCase{
        return UpdateTvShowUseCase(tvShowRepository)
    }


}