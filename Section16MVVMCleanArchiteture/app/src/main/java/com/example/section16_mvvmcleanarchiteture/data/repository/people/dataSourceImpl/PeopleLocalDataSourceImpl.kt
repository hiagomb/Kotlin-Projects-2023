package com.example.section16_mvvmcleanarchiteture.data.repository.people.dataSourceImpl

import com.example.section16_mvvmcleanarchiteture.data.db.PeopleDAO
import com.example.section16_mvvmcleanarchiteture.data.model.people.People
import com.example.section16_mvvmcleanarchiteture.data.repository.people.dataSource.PeopleLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PeopleLocalDataSourceImpl(private val peopleDAO: PeopleDAO): PeopleLocalDataSource {

    override suspend fun getPeopleFromDB() = peopleDAO.getPeople()

    override suspend fun savePeopleToDB(people: List<People>) {
        CoroutineScope(Dispatchers.IO).launch {
            peopleDAO.savePeople(people)
        }
    }

    override suspend fun deleteAll() {
        CoroutineScope(Dispatchers.IO).launch {
            peopleDAO.deleteAllPeople()
        }
    }
}