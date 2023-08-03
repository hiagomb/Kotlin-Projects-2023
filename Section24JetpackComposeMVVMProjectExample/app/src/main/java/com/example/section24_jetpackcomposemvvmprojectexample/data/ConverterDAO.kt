package com.example.section24_jetpackcomposemvvmprojectexample.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ConverterDAO {

    @Insert
    suspend fun insert(conversionResult: ConversionResult)

    @Delete
    suspend fun delete(conversionResult: ConversionResult)

    @Query("DELETE FROM result_table")
    suspend fun deletelAll()

    @Query("SELECT * FROM result_table")
    fun getAll(): Flow<List<ConversionResult>>
}