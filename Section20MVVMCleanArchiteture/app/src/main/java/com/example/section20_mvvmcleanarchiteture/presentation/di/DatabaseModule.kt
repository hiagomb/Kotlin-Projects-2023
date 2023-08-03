package com.example.section20_mvvmcleanarchiteture.presentation.di

import android.app.Application
import androidx.room.Room
import com.example.section20_mvvmcleanarchiteture.data.db.ArticleDao
import com.example.section20_mvvmcleanarchiteture.data.db.ArticleDatabase
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
    fun providesRoom(application: Application): ArticleDatabase{
        return Room.databaseBuilder(application.applicationContext,
            ArticleDatabase::class.java, "news_db").build()
    }


    @Singleton
    @Provides
    fun providesArticleDao(articleDatabase: ArticleDatabase): ArticleDao{
        return articleDatabase.getArticleDao()
    }
}