package com.example.section16_mvvmcleanarchiteture.presentation.people

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.section16_mvvmcleanarchiteture.R
import com.example.section16_mvvmcleanarchiteture.databinding.ActivityPeopleBinding

class PeopleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPeopleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_people)
    }
}