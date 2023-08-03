package com.example.section16_mvvmcleanarchiteture.data.repository.movie

import com.example.section16_mvvmcleanarchiteture.data.model.movie.Movie
import com.example.section16_mvvmcleanarchiteture.data.repository.movie.dataSource.MovieCacheDataSource
import com.example.section16_mvvmcleanarchiteture.data.repository.movie.dataSource.MovieLocalDataSource
import com.example.section16_mvvmcleanarchiteture.data.repository.movie.dataSource.MovieRemoteDataSource
import com.example.section16_mvvmcleanarchiteture.domain.repository.MovieRepository

class MovieRepositoryImpl(private val movieRemoteDataSource: MovieRemoteDataSource,
                          private val movieLocalDataSource: MovieLocalDataSource,
                          private val movieCacheDataSource: MovieCacheDataSource
): MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromApi()
        movieLocalDataSource.deleteAll()
        movieLocalDataSource.saveMoviesToDatabase(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromApi(): List<Movie>{
        lateinit var movieList: List<Movie>

        try{
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if(body != null){
                movieList = body.movies
            }
        }catch(e: java.lang.Exception){
            e.printStackTrace()
        }

        return movieList
    }


    suspend fun getMoviesFromDB(): List<Movie>{
        lateinit var movieList: List<Movie>

        try{
            movieList = movieLocalDataSource.getMoviesFromDB()
        }catch(e: java.lang.Exception){
            e.printStackTrace()
        }
        if(movieList.size > 0){
            return movieList
        }else{
            movieList = getMoviesFromApi()
            movieLocalDataSource.saveMoviesToDatabase(movieList)
            return movieList
        }

    }


    suspend fun getMoviesFromCache(): List<Movie>{
        lateinit var movieList: List<Movie>

        try{
            movieList = movieCacheDataSource.getMoviesFromCache()
        }catch(e: java.lang.Exception){
            e.printStackTrace()
        }
        if(movieList.size > 0){
            return movieList
        }else{
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
            return movieList
        }
    }


}