package com.example.section16_mvvmcleanarchiteture.domain.usecase

import com.example.section16_mvvmcleanarchiteture.data.model.people.People
import com.example.section16_mvvmcleanarchiteture.domain.repository.PeopleRepository

class GetPeopleUseCase (private val peopleRepository: PeopleRepository){

    suspend fun execute(): List<People>? = peopleRepository.getPeople()
}