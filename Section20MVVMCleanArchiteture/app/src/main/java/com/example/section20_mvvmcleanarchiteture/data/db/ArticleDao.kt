package com.example.section20_mvvmcleanarchiteture.data.db

import androidx.room.*
import com.example.section20_mvvmcleanarchiteture.data.model.Article
import kotlinx.coroutines.flow.Flow


@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article)

    @Delete
    suspend fun delete(article: Article)

    @Query("SELECT * FROM Article")
    fun getSavedNews(): Flow<List<Article>>
}