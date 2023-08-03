package com.example.section16_mvvmcleanarchiteture.data.repository.tvShow.dataSource

import com.example.section16_mvvmcleanarchiteture.data.model.tvShow.TvShow

interface TvShowCacheDataSource {

    suspend fun getTvShowsFromCache(): List<TvShow>

    suspend fun saveTvShowsToCache(tvShowList: List<TvShow>)
}