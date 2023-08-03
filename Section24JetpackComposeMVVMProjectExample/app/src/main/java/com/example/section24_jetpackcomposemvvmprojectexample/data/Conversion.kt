package com.example.section24_jetpackcomposemvvmprojectexample.data

data class Conversion(
    val id: Int,
    val description: String,
    val convertFrom: String,
    val convertTo: String,
    val multiplyBy: Double
)