package com.example.section16_mvvmcleanarchiteture.domain.repository

import com.example.section16_mvvmcleanarchiteture.data.model.tvShow.TvShow

interface TvShowRepository {

    suspend fun getTvShows(): List<TvShow>?

    suspend fun updateTbShows(): List<TvShow>?
}