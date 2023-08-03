package com.example.study_normalvscoroutine.listener

interface ApiListener<T> {

    fun onSuccess(result: T)
    fun onFailure(result: T)
}