package com.example.section16_mvvmcleanarchiteture.data.repository.tvShow.dataSourceImpl

import com.example.section16_mvvmcleanarchiteture.data.api.TMDBService
import com.example.section16_mvvmcleanarchiteture.data.model.tvShow.TVShowList
import com.example.section16_mvvmcleanarchiteture.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(private val tmdbService: TMDBService,
                                 private val apiKey: String): TvShowRemoteDataSource {

    override suspend fun getTvShow(): Response<TVShowList> {
        return tmdbService.getPopularTvShows(apiKey)
    }
}