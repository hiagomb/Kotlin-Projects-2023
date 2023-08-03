package com.example.section24_jetpackcomposemvvmprojectexample.presentation.di

import com.example.section24_jetpackcomposemvvmprojectexample.data.ConverterDAO
import com.example.section24_jetpackcomposemvvmprojectexample.data.ConverterRepository
import com.example.section24_jetpackcomposemvvmprojectexample.data.ConverterRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class
)
class RepositoryModule {

    @Singleton
    @Provides
    fun providesRepository(dao: ConverterDAO): ConverterRepository{
        return ConverterRepositoryImpl(dao)
    }
}