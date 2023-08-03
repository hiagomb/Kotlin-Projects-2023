package com.example.section16_mvvmcleanarchiteture.data.model.people


import com.google.gson.annotations.SerializedName

data class PeopleList(
    @SerializedName("results")
    val people: List<People>
)