package com.example.section16_mvvmcleanarchiteture.presentation.di.people

import com.example.section16_mvvmcleanarchiteture.presentation.people.PeopleActivity
import dagger.Subcomponent

@PeopleScope
@Subcomponent(modules = [PeopleModule::class])
interface PeopleSubComponent {

    fun inject(peopleActivity: PeopleActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): PeopleSubComponent
    }
}