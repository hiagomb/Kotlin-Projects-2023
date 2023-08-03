package com.example.section16_mvvmcleanarchiteture.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.section16_mvvmcleanarchiteture.data.model.tvShow.TvShow

@Dao
interface TvShowDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShows: List<TvShow>)

    @Query("DELETE FROM TvShow")
    suspend fun deleteAllTvShows()

    @Query("SELECT * FROM TvShow")
    suspend fun getTvShows(): List<TvShow>
}