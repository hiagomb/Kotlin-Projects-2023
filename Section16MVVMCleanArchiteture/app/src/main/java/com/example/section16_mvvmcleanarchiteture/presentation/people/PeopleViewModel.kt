package com.example.section16_mvvmcleanarchiteture.presentation.people

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.section16_mvvmcleanarchiteture.domain.usecase.GetPeopleUseCase
import com.example.section16_mvvmcleanarchiteture.domain.usecase.UpdatePeopleUseCase

class PeopleViewModel(private val getPeopleUseCase: GetPeopleUseCase,
                      private val updatePeopleUseCase: UpdatePeopleUseCase): ViewModel() {

    fun getPeople() = liveData {
        val peopleList =  getPeopleUseCase.execute()
        emit(peopleList)
    }

    fun updatePeople() = liveData {
        val peopleList =  updatePeopleUseCase.execute()
        emit(peopleList)
    }
}