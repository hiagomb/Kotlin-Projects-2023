package com.example.section16_mvvmcleanarchiteture.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.section16_mvvmcleanarchiteture.data.db.AppDatabase
import com.example.section16_mvvmcleanarchiteture.data.db.MovieDAO
import com.example.section16_mvvmcleanarchiteture.data.db.PeopleDAO
import com.example.section16_mvvmcleanarchiteture.data.db.TvShowDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule {


    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context): AppDatabase{
        return Room.databaseBuilder(context, AppDatabase::class.java, "AppDatabase").build()
    }

    @Singleton
    @Provides
    fun provideMovieDAO(appDatabase: AppDatabase): MovieDAO{
        return appDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun providePeopleDAO(appDatabase: AppDatabase): PeopleDAO{
        return appDatabase.peopleDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDAO(appDatabase: AppDatabase): TvShowDAO{
        return appDatabase.tvShowDao()
    }

}