package com.example.section16_mvvmcleanarchiteture.presentation.di.tvSHow

import com.example.section16_mvvmcleanarchiteture.domain.usecase.GetMoviesUseCase
import com.example.section16_mvvmcleanarchiteture.domain.usecase.GetTvShowUseCase
import com.example.section16_mvvmcleanarchiteture.domain.usecase.UpdateMoviesUseCase
import com.example.section16_mvvmcleanarchiteture.domain.usecase.UpdateTvShowUseCase
import com.example.section16_mvvmcleanarchiteture.presentation.movie.MovieViewModelFactory
import com.example.section16_mvvmcleanarchiteture.presentation.tvShow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(getTvShowUseCase: GetTvShowUseCase,
                                     updateTvShowUseCase: UpdateTvShowUseCase)
    : TvShowViewModelFactory{

        return TvShowViewModelFactory(getTvShowUseCase, updateTvShowUseCase)
    }

}