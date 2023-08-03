package com.example.section20_mvvmcleanarchiteture.presentation.di

import com.example.section20_mvvmcleanarchiteture.presentation.adapter.RecyclerNewsAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {

    @Singleton
    @Provides
    fun providesAdapter(): RecyclerNewsAdapter{
        return RecyclerNewsAdapter()
    }
}