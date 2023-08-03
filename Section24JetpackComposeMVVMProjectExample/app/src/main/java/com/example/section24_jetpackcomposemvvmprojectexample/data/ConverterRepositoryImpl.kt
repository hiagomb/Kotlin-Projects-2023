package com.example.section24_jetpackcomposemvvmprojectexample.data

import kotlinx.coroutines.flow.Flow

class ConverterRepositoryImpl(private val converterDAO: ConverterDAO): ConverterRepository {
    override suspend fun insert(conversionResult: ConversionResult) {
        converterDAO.insert(conversionResult)
    }

    override suspend fun delete(conversionResult: ConversionResult) {
        converterDAO.delete(conversionResult)
    }

    override suspend fun deleteAll() {
        converterDAO.deletelAll()
    }

    override fun getAll(): Flow<List<ConversionResult>> {
        return converterDAO.getAll()
    }
}