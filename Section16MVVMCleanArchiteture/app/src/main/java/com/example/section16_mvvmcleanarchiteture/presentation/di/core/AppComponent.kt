package com.example.section16_mvvmcleanarchiteture.presentation.di.core

import com.example.section16_mvvmcleanarchiteture.presentation.di.movie.MovieSubComponent
import com.example.section16_mvvmcleanarchiteture.presentation.di.people.PeopleSubComponent
import com.example.section16_mvvmcleanarchiteture.presentation.di.tvSHow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    CacheDataModule::class,
    DatabaseModule::class,
    LocalDataModule::class,
    NetModule::class,
    RemoteDataModule::class,
    UseCaseModule::class,
    RepositoryModule::class
])
interface AppComponent {


    fun movieSubComponent(): MovieSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory
    fun peopleSubComponent(): PeopleSubComponent.Factory
}