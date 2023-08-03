package com.example.study_normalvscoroutine.repository.remote

import com.example.study_normalvscoroutine.model.CepResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CepService {

//    @GET("{cep}/json/")
//    fun getCep(@Path("cep") cepNumber: String): Call<CepResponse>

    @GET("{cep}/json/")
    suspend fun getCepWithCoroutine(@Path("cep") cepNumber: String): Response<CepResponse>
}