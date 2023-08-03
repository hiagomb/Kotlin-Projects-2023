package com.example.study_normalvscoroutine.repository.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "https://viacep.com.br/ws/"

    private val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()


    val cepService: CepService by lazy{
        retrofit.create(CepService::class.java)
    }

}
