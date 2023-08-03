package com.example.section16_mvvmcleanarchiteture.presentation

import android.app.Application
import com.example.section16_mvvmcleanarchiteture.presentation.di.Injector
import com.example.section16_mvvmcleanarchiteture.presentation.di.core.AppComponent
import com.example.section16_mvvmcleanarchiteture.presentation.di.movie.MovieSubComponent
import com.example.section16_mvvmcleanarchiteture.presentation.di.people.PeopleSubComponent
import com.example.section16_mvvmcleanarchiteture.presentation.di.tvSHow.TvShowSubComponent

class App: Application(), Injector {

    private lateinit var appComponent: AppComponent


    override fun onCreate() {
        super.onCreate()

    }

    override fun createMovieSubComponent(): MovieSubComponent {
        TODO("Not yet implemented")
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        TODO("Not yet implemented")
    }

    override fun createPeopleSubComponent(): PeopleSubComponent {
        TODO("Not yet implemented")
    }
}