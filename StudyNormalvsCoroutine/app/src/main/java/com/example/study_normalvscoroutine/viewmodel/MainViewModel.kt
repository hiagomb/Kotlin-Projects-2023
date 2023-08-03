package com.example.study_normalvscoroutine.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.study_normalvscoroutine.listener.ApiListener
import com.example.study_normalvscoroutine.model.CepResponse
import com.example.study_normalvscoroutine.repository.CepRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel(){

    private val cepRepository = CepRepository()
    private val _cepResponse = MutableLiveData<CepResponse>()
    val cepResponse: LiveData<CepResponse> = _cepResponse

//    fun getCep(cepNumber: String){
//        cepRepository.getCep(cepNumber, object : ApiListener<CepResponse>{
//            override fun onSuccess(result: CepResponse) {
//                _cepResponse.value = result
//            }
//
//            override fun onFailure(result: CepResponse) {
//                _cepResponse.value = result
//            }
//
//        })
//    }


    fun getCepWithCoroutine(cepNumber: String){
        viewModelScope.launch {
            val response = cepRepository.getCepWithCoroutine(cepNumber)
            _cepResponse.postValue(response)
        }


    }


}