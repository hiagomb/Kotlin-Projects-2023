package com.example.section16_mvvmcleanarchiteture.data.repository.tvShow.dataSource

import com.example.section16_mvvmcleanarchiteture.data.model.people.People
import com.example.section16_mvvmcleanarchiteture.data.model.tvShow.TvShow

interface TvShowLocalDataSource {

    suspend fun getTvShowsFromDB(): List<TvShow>

    suspend fun saveTvShowsToDB(tvShowList: List<TvShow>)

    suspend fun deleteAll()
}