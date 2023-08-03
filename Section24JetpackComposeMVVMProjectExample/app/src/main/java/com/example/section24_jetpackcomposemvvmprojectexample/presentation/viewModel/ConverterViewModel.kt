package com.example.section24_jetpackcomposemvvmprojectexample.presentation.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.section24_jetpackcomposemvvmprojectexample.data.Conversion
import com.example.section24_jetpackcomposemvvmprojectexample.data.ConversionResult
import com.example.section24_jetpackcomposemvvmprojectexample.data.ConverterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ConverterViewModel(private val converterRepository: ConverterRepository): ViewModel() {

    val selectedConversion: MutableState<Conversion?> = mutableStateOf(null)
    val inputText: MutableState<String> = mutableStateOf("")
    var typedValue =  mutableStateOf("0.0")


    fun getConversions() = listOf(
        Conversion(1, "Pounds to Kilograms", "lbs", "kg", 0.453592),
        Conversion(2, "Kilograms to Pounds", "kg", "lbs", 2.20462),
        Conversion(3, "Yards to Meters", "yd", "m", 0.9144),
        Conversion(4, "Meters to Yards", "m", "yd", 1.09361),
        Conversion(5, "Miles to Kilometers", "mi", "km", 1.60934),
        Conversion(6, "Kilometers to Miles", "km", "mi", 0.621371)
    )


    fun addResult(message1: String, message2: String){
        viewModelScope.launch(Dispatchers.IO) {
            converterRepository.insert(ConversionResult(0,  message1, message2))
        }
    }

    val resultList = converterRepository.getAll()

    fun delete(conversionResult: ConversionResult){
        viewModelScope.launch {
            converterRepository.delete(conversionResult)
        }
    }


    fun deleteAll(){
        viewModelScope.launch {
            converterRepository.deleteAll()
        }
    }

    class ConverterViewModelFactory(private val converterRepository: ConverterRepository): ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ConverterViewModel(converterRepository) as T
        }
    }


}