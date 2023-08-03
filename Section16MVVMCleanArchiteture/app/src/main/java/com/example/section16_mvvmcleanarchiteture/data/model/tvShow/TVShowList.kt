package com.example.section16_mvvmcleanarchiteture.data.model.tvShow


import com.google.gson.annotations.SerializedName

data class TVShowList(
    @SerializedName("results")
    val tvShows: List<TvShow>
)