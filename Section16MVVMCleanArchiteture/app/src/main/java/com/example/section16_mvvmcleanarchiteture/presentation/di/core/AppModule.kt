package com.example.section16_mvvmcleanarchiteture.presentation.di.core

import android.content.Context
import com.example.section16_mvvmcleanarchiteture.presentation.di.movie.MovieSubComponent
import com.example.section16_mvvmcleanarchiteture.presentation.di.people.PeopleSubComponent
import com.example.section16_mvvmcleanarchiteture.presentation.di.tvSHow.TvShowSubComponent
import dagger.Module
import dagger.Provides

@Module(subcomponents = [
    MovieSubComponent::class,
    PeopleSubComponent::class,
    TvShowSubComponent::class
])
class AppModule(private val context: Context) {

    @Provides
    fun provideContext(): Context{
        return context.applicationContext
    }
}