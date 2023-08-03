package com.example.section16_mvvmcleanarchiteture.data.repository.people

import com.example.section16_mvvmcleanarchiteture.data.model.movie.Movie
import com.example.section16_mvvmcleanarchiteture.data.model.people.People
import com.example.section16_mvvmcleanarchiteture.data.repository.people.dataSource.PeopleCacheDataSource
import com.example.section16_mvvmcleanarchiteture.data.repository.people.dataSource.PeopleLocalDataSource
import com.example.section16_mvvmcleanarchiteture.data.repository.people.dataSource.PeopleRemoteDataSource
import com.example.section16_mvvmcleanarchiteture.domain.repository.PeopleRepository

class PeopleRepositoryImpl(private val peopleCacheDataSource: PeopleCacheDataSource,
                           private val peopleLocalDataSource: PeopleLocalDataSource,
                           private val peopleRemoteDataSource: PeopleRemoteDataSource): PeopleRepository {


    override suspend fun getPeople(): List<People>? {
        return getPeopleFromCache()
    }

    override suspend fun updatePeople(): List<People>? {
        val peopleList = getPeopleFromApi()
        peopleCacheDataSource.savePeopleToCache(peopleList)
        peopleLocalDataSource.deleteAll()
        peopleLocalDataSource.savePeopleToDB(peopleList)
        return peopleList
    }

    suspend fun getPeopleFromApi(): List<People> {
        lateinit var peopleList: List<People>
        val response = peopleRemoteDataSource.getPeople()
        if(response.body() != null){
            peopleList = response.body()!!.people
        }
        return peopleList
    }

    suspend fun getPeopleFromDB(): List<People>{
        lateinit var peopleList: List<People>
        peopleList = peopleLocalDataSource.getPeopleFromDB()
        if(peopleList.size > 0){
            return peopleList
        }
        peopleList = getPeopleFromApi()
        peopleLocalDataSource.savePeopleToDB(peopleList)
        return peopleList
    }

    suspend fun getPeopleFromCache(): List<People>{
        var peopleList = peopleCacheDataSource.getPeopleFromCache()
        if(peopleList.size > 0){
            return peopleList
        }
        peopleList = getPeopleFromDB()
        peopleCacheDataSource.savePeopleToCache(peopleList)
        return peopleList
    }
}