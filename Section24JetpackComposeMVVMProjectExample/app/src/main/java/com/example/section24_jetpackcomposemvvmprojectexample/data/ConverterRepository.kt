package com.example.section24_jetpackcomposemvvmprojectexample.data

import kotlinx.coroutines.flow.Flow

interface ConverterRepository {

    suspend fun insert(conversionResult: ConversionResult)
    suspend fun delete(conversionResult: ConversionResult)
    suspend fun deleteAll()
    fun getAll(): Flow<List<ConversionResult>>
}