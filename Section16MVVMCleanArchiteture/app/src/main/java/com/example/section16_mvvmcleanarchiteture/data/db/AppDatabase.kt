package com.example.section16_mvvmcleanarchiteture.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.section16_mvvmcleanarchiteture.data.model.movie.Movie
import com.example.section16_mvvmcleanarchiteture.data.model.people.People
import com.example.section16_mvvmcleanarchiteture.data.model.tvShow.TvShow

@Database(entities = [Movie::class, TvShow::class, People::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDAO
    abstract fun peopleDao(): PeopleDAO
    abstract fun tvShowDao(): TvShowDAO
}