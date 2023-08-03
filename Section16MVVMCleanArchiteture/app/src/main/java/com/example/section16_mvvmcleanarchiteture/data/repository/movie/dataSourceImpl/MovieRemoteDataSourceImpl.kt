package com.example.section16_mvvmcleanarchiteture.data.repository.movie.dataSourceImpl

import com.example.section16_mvvmcleanarchiteture.data.api.TMDBService
import com.example.section16_mvvmcleanarchiteture.data.model.movie.MovieList
import com.example.section16_mvvmcleanarchiteture.data.repository.movie.dataSource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val tmdbService: TMDBService,
                                private val apiKey: String): MovieRemoteDataSource {

    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)

}