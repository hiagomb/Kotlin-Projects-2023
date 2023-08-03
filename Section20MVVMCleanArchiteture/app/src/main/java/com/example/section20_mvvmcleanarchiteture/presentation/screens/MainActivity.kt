package com.example.section20_mvvmcleanarchiteture.presentation.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.section20_mvvmcleanarchiteture.R
import com.example.section20_mvvmcleanarchiteture.databinding.ActivityMainBinding
import com.example.section20_mvvmcleanarchiteture.presentation.adapter.RecyclerNewsAdapter
import com.example.section20_mvvmcleanarchiteture.presentation.viewModel.NewsViewModel
import com.example.section20_mvvmcleanarchiteture.presentation.viewModel.NewsViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: NewsViewModel
    @Inject lateinit var viewModelFactory: NewsViewModelFactory
    @Inject lateinit var newsAdapter: RecyclerNewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)

        viewModel = ViewModelProvider(this, viewModelFactory).get(NewsViewModel::class.java)
    }
}