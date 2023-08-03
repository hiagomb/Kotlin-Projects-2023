package com.example.section16_mvvmcleanarchiteture.presentation.di.movie

import com.example.section16_mvvmcleanarchiteture.domain.usecase.GetMoviesUseCase
import com.example.section16_mvvmcleanarchiteture.domain.usecase.UpdateMoviesUseCase
import com.example.section16_mvvmcleanarchiteture.presentation.di.people.PeopleScope
import com.example.section16_mvvmcleanarchiteture.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(getMoviesUseCase: GetMoviesUseCase,
                                     updateMoviesUseCase: UpdateMoviesUseCase)
    : MovieViewModelFactory{

        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }

}