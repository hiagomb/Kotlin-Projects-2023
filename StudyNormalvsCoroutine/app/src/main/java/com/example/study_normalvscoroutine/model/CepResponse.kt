package com.example.study_normalvscoroutine.model

data class CepResponse(val cep: String, val logradouro: String = "", val complemento: String = "",
        val bairro: String = "", val localidade: String = "", val uf: String = "", val ibge: String = "")