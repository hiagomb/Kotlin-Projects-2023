package com.example.section16_mvvmcleanarchiteture.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.section16_mvvmcleanarchiteture.data.model.people.People

@Dao
interface PeopleDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePeople(people: List<People>)

    @Query("DELETE FROM People")
    suspend fun deleteAllPeople()

    @Query("SELECT * FROM People")
    suspend fun getPeople(): List<People>
}