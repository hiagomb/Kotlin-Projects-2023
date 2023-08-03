package com.example.section24_jetpackcomposemvvmprojectexample.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "result_table")
data class ConversionResult(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val message1: String,
    val message2: String
)