package com.example.section16_mvvmcleanarchiteture.presentation.people

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.section16_mvvmcleanarchiteture.domain.usecase.GetPeopleUseCase
import com.example.section16_mvvmcleanarchiteture.domain.usecase.UpdatePeopleUseCase

class PeopleViewModelFactory(private val getPeopleUseCase: GetPeopleUseCase,
                             private val updatePeopleUseCase: UpdatePeopleUseCase):
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PeopleViewModel(getPeopleUseCase, updatePeopleUseCase) as T
    }

}