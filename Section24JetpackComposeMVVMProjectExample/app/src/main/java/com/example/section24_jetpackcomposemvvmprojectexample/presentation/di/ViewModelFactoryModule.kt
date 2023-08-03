package com.example.section24_jetpackcomposemvvmprojectexample.presentation.di

import com.example.section24_jetpackcomposemvvmprojectexample.data.ConverterRepository
import com.example.section24_jetpackcomposemvvmprojectexample.presentation.viewModel.ConverterViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ViewModelFactoryModule {


    @Singleton
    @Provides
    fun providesViewModelFactory(converterRepository: ConverterRepository): ConverterViewModel.ConverterViewModelFactory {
        return ConverterViewModel.ConverterViewModelFactory(converterRepository)
    }
}