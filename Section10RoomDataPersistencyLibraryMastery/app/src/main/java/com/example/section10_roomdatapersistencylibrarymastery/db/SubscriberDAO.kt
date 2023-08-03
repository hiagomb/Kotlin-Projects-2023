package com.example.section10_roomdatapersistencylibrarymastery.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SubscriberDAO {

    @Query("SELECT * FROM subscriber_data_table")
    suspend fun getAll(): List<Subscriber>

    @Insert
    suspend fun insert(subscriber: Subscriber): Long

    @Update
    suspend fun update(subscriber: Subscriber): Int

    @Delete
    suspend fun delete(subscriber: Subscriber): Int

    @Query("DELETE FROM subscriber_data_table")
    suspend fun clearAll(): Int
}