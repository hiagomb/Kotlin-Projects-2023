package com.example.section16_mvvmcleanarchiteture.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.section16_mvvmcleanarchiteture.R
import com.example.section16_mvvmcleanarchiteture.databinding.ActivityHomeBinding
import com.example.section16_mvvmcleanarchiteture.presentation.movie.MovieActivity
import com.example.section16_mvvmcleanarchiteture.presentation.people.PeopleActivity
import com.example.section16_mvvmcleanarchiteture.presentation.tvShow.TvShowActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        goToFeatures()
    }


    private fun goToFeatures(){
        binding.movieButton.setOnClickListener{
            startActivity(Intent(this, MovieActivity::class.java))
        }
        binding.peopleButton.setOnClickListener{
            startActivity(Intent(this, PeopleActivity::class.java))
        }
        binding.tvShowButton.setOnClickListener{
            startActivity(Intent(this, TvShowActivity::class.java))
        }
    }
}