package com.example.section16_mvvmcleanarchiteture.data.db

import androidx.room.*
import com.example.section16_mvvmcleanarchiteture.data.model.movie.Movie

@Dao
interface MovieDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query("DELETE FROM Movie")
    suspend fun deleteAllMovies()

    @Query("SELECT * FROM Movie")
    suspend fun getMovies(): List<Movie>
}