package com.example.section24_jetpackcomposemvvmprojectexample.presentation.di

import android.app.Application
import androidx.room.Room
import com.example.section24_jetpackcomposemvvmprojectexample.data.ConverterDAO
import com.example.section24_jetpackcomposemvvmprojectexample.data.ConverterDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun providesRoom(application: Application): ConverterDatabase{
        return Room.databaseBuilder(
            application.applicationContext,
            ConverterDatabase::class.java,
            "converter_database"
        ).build()
    }

    @Singleton
    @Provides
    fun providesConverterDAO(converterDatabase: ConverterDatabase): ConverterDAO{
        return converterDatabase.getConverterDAO()
    }
}