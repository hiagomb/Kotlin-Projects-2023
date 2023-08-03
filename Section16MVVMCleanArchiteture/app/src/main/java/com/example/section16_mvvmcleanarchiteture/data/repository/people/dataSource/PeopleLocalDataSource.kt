package com.example.section16_mvvmcleanarchiteture.data.repository.people.dataSource

import com.example.section16_mvvmcleanarchiteture.data.model.people.People

interface PeopleLocalDataSource {

    suspend fun getPeopleFromDB(): List<People>
    suspend fun savePeopleToDB(people: List<People>)
    suspend fun deleteAll()
}