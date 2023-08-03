package com.example.study_normalvscoroutine.repository

import com.example.study_normalvscoroutine.listener.ApiListener
import com.example.study_normalvscoroutine.model.CepResponse
import com.example.study_normalvscoroutine.repository.remote.RetrofitClient
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CepRepository {

    private val cepService = RetrofitClient.cepService

//    fun getCep(cepNumber: String, listener: ApiListener<CepResponse>){
//        cepService.getCep(cepNumber).enqueue(object : Callback<CepResponse>{
//            override fun onResponse(call: Call<CepResponse>, response: Response<CepResponse>) {
//                if(response.code() == 200){
//                    response.body()?.let { listener.onSuccess(it) }
//                }else{
//                    listener.onFailure(Gson().fromJson(response.errorBody()?.string(),
//                        CepResponse::class.java))
//                }
//            }
//
//            override fun onFailure(call: Call<CepResponse>, t: Throwable) {
//                listener.onFailure(CepResponse("failure"))
//            }
//
//        })
//    }

    suspend fun getCepWithCoroutine(cepNumber: String): CepResponse?{
        val response = cepService.getCepWithCoroutine(cepNumber)
        if(response.isSuccessful){
            return response.body()!!
        }
        return null
    }
}