package com.example.section16_mvvmcleanarchiteture.presentation.di.people

import com.example.section16_mvvmcleanarchiteture.domain.usecase.GetPeopleUseCase
import com.example.section16_mvvmcleanarchiteture.domain.usecase.UpdatePeopleUseCase
import com.example.section16_mvvmcleanarchiteture.presentation.people.PeopleViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class PeopleModule {

    @PeopleScope
    @Provides
    fun providePeopleViewModelFactory(getPeopleUseCase: GetPeopleUseCase,
                                      updatePeopleUseCase: UpdatePeopleUseCase)
    : PeopleViewModelFactory{

        return PeopleViewModelFactory(getPeopleUseCase, updatePeopleUseCase)
    }
}