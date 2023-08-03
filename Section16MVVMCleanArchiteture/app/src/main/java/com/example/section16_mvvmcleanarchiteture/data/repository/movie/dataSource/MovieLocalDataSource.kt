package com.example.section16_mvvmcleanarchiteture.data.repository.movie.dataSource

import com.example.section16_mvvmcleanarchiteture.data.model.movie.Movie

interface MovieLocalDataSource {

    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDatabase(movies: List<Movie>)
    suspend fun deleteAll()
}