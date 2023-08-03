package com.example.section20_mvvmcleanarchiteture.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.section20_mvvmcleanarchiteture.data.model.Article

@Database(entities = [Article::class], version = 1)
@TypeConverters(Converters::class)

abstract class ArticleDatabase: RoomDatabase() {

    abstract fun getArticleDao(): ArticleDao
}