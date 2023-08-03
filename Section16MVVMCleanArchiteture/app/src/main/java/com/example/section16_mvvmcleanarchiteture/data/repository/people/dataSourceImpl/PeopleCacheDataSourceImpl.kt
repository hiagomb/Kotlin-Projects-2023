package com.example.section16_mvvmcleanarchiteture.data.repository.people.dataSourceImpl

import com.example.section16_mvvmcleanarchiteture.data.model.people.People
import com.example.section16_mvvmcleanarchiteture.data.model.people.PeopleList
import com.example.section16_mvvmcleanarchiteture.data.repository.people.dataSource.PeopleCacheDataSource

class PeopleCacheDataSourceImpl: PeopleCacheDataSource {

    private var peopleList = ArrayList<People>()

    override suspend fun savePeopleToCache(people: List<People>) {
        peopleList.clear()
        peopleList = people as ArrayList<People>
    }

    override suspend fun getPeopleFromCache() = peopleList
}