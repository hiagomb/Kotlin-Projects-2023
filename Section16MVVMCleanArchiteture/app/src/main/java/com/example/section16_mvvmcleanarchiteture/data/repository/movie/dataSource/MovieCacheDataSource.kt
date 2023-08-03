package com.example.section16_mvvmcleanarchiteture.data.repository.movie.dataSource

import com.example.section16_mvvmcleanarchiteture.data.model.movie.Movie

interface MovieCacheDataSource {

    suspend fun saveMoviesToCache(movies: List<Movie>)

    suspend fun getMoviesFromCache(): List<Movie>
}