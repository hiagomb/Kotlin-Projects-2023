package com.example.section16_mvvmcleanarchiteture.data.repository.movie.dataSourceImpl

import com.example.section16_mvvmcleanarchiteture.data.model.movie.Movie
import com.example.section16_mvvmcleanarchiteture.data.repository.movie.dataSource.MovieCacheDataSource

class MovieCacheDataSourceImpl: MovieCacheDataSource {

    private var movieList = ArrayList<Movie>()

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = movies as ArrayList<Movie>
    }

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }
}