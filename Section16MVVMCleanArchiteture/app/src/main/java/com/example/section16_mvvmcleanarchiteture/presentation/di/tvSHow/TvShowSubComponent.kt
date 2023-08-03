package com.example.section16_mvvmcleanarchiteture.presentation.di.tvSHow

import com.example.section16_mvvmcleanarchiteture.presentation.movie.MovieActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): TvShowSubComponent
    }
}