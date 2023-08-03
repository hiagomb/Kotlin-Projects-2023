package com.example.section16_mvvmcleanarchiteture.data.repository.tvShow.dataSource

import com.example.section16_mvvmcleanarchiteture.data.model.tvShow.TVShowList
import retrofit2.Response

interface TvShowRemoteDataSource {

    suspend fun getTvShow(): Response<TVShowList>
}