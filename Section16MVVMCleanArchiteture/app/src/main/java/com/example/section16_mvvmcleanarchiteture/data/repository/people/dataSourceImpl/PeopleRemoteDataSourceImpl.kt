package com.example.section16_mvvmcleanarchiteture.data.repository.people.dataSourceImpl

import com.example.section16_mvvmcleanarchiteture.data.api.TMDBService
import com.example.section16_mvvmcleanarchiteture.data.model.people.PeopleList
import com.example.section16_mvvmcleanarchiteture.data.repository.people.dataSource.PeopleRemoteDataSource

class PeopleRemoteDataSourceImpl(private val tmdbService: TMDBService,
                                 private val apiKey: String): PeopleRemoteDataSource {

    override suspend fun getPeople() = tmdbService.getPopularPeople(apiKey)
}