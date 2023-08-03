package com.example.section16_mvvmcleanarchiteture.data.repository.people.dataSource

import com.example.section16_mvvmcleanarchiteture.data.model.people.People
import com.example.section16_mvvmcleanarchiteture.data.model.people.PeopleList
import retrofit2.Response

interface PeopleRemoteDataSource {

    suspend fun getPeople(): Response<PeopleList>
}