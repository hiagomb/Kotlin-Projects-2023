package com.example.section16_mvvmcleanarchiteture.data.model.movie
import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>
)