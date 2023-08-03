package com.example.section16_mvvmcleanarchiteture.data.repository.movie.dataSourceImpl

import com.example.section16_mvvmcleanarchiteture.data.db.MovieDAO
import com.example.section16_mvvmcleanarchiteture.data.model.movie.Movie
import com.example.section16_mvvmcleanarchiteture.data.repository.movie.dataSource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDAO: MovieDAO): MovieLocalDataSource {

    override suspend fun getMoviesFromDB(): List<Movie> = movieDAO.getMovies()

    override suspend fun saveMoviesToDatabase(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.saveMovies(movies)
        }
    }

    override suspend fun deleteAll()  {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.deleteAllMovies()
        }
    }
}