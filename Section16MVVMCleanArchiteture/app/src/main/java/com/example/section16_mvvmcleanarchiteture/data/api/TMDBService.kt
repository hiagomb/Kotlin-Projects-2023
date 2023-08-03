package com.example.section16_mvvmcleanarchiteture.data.api

import com.example.section16_mvvmcleanarchiteture.data.model.movie.MovieList
import com.example.section16_mvvmcleanarchiteture.data.model.people.PeopleList
import com.example.section16_mvvmcleanarchiteture.data.model.tvShow.TVShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): Response<MovieList>

    @GET("person/popular")
    suspend fun getPopularPeople(@Query("api_key") apiKey: String): Response<PeopleList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key") apiKey: String): Response<TVShowList>
}