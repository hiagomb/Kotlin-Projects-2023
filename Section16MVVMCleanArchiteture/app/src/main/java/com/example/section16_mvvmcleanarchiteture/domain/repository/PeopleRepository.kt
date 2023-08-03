package com.example.section16_mvvmcleanarchiteture.domain.repository

import com.example.section16_mvvmcleanarchiteture.data.model.people.People

interface PeopleRepository {

    suspend fun getPeople(): List<People>?

    suspend fun updatePeople(): List<People>?
}