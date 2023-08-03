package com.example.section20_mvvmcleanarchiteture.presentation.di

import android.app.Application
import com.example.section20_mvvmcleanarchiteture.domain.useCase.*
import com.example.section20_mvvmcleanarchiteture.presentation.viewModel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NewsViewModelFactoryModule {

    @Singleton
    @Provides
    fun providesNewsViewModelFactory(getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
                                     getSearchedNewsUseCase: GetSearchedNewsUseCase,
                                     saveNewsUseCase: SaveNewsUseCase,
                                     getSavedNewsUseCase: GetSavedNewsUseCase,
                                     deleteSavedNewsUseCase: DeleteSavedNewsUseCase,
                                     application: Application): NewsViewModelFactory{
        return NewsViewModelFactory(getNewsHeadlinesUseCase, getSearchedNewsUseCase,
            saveNewsUseCase, getSavedNewsUseCase, deleteSavedNewsUseCase, application)
    }
}