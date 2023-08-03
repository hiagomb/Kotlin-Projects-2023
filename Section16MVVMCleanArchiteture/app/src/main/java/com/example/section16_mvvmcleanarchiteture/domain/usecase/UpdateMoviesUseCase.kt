package com.example.section16_mvvmcleanarchiteture.domain.usecase

import com.example.section16_mvvmcleanarchiteture.data.model.movie.Movie
import com.example.section16_mvvmcleanarchiteture.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()
}