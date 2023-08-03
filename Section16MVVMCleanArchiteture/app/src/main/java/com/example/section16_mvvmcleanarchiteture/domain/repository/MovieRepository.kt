package com.example.section16_mvvmcleanarchiteture.domain.repository

import com.example.section16_mvvmcleanarchiteture.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?

    suspend fun updateMovies(): List<Movie>?
}