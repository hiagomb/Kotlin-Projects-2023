package com.example.section16_mvvmcleanarchiteture.data.repository.people.dataSource

import com.example.section16_mvvmcleanarchiteture.data.model.people.People

interface PeopleCacheDataSource {

    suspend fun savePeopleToCache(people: List<People>)

    suspend fun getPeopleFromCache(): List<People>
}