package com.example.section16_mvvmcleanarchiteture.presentation.di

import com.example.section16_mvvmcleanarchiteture.presentation.di.movie.MovieSubComponent
import com.example.section16_mvvmcleanarchiteture.presentation.di.people.PeopleSubComponent
import com.example.section16_mvvmcleanarchiteture.presentation.di.tvSHow.TvShowSubComponent

interface Injector {

    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createPeopleSubComponent(): PeopleSubComponent
}