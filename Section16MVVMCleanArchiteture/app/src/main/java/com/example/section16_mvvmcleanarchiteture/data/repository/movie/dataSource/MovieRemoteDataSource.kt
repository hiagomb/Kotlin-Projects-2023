package com.example.section16_mvvmcleanarchiteture.data.repository.movie.dataSource

import com.example.section16_mvvmcleanarchiteture.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovies(): Response<MovieList>
}