package com.example.section16_mvvmcleanarchiteture.presentation.di.core

import com.example.section16_mvvmcleanarchiteture.data.api.TMDBService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl: String){


    @Singleton
    @Provides
    fun provideRetrofitInstance(): Retrofit{
        return Retrofit.Builder().baseUrl(baseUrl).
        addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun provideTmdbService(retrofit: Retrofit): TMDBService{
        return retrofit.create(TMDBService::class.java)
    }
}