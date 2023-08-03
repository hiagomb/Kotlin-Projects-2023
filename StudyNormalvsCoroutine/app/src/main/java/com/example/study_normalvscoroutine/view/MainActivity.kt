package com.example.study_normalvscoroutine.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import com.example.study_normalvscoroutine.databinding.ActivityMainBinding
import com.example.study_normalvscoroutine.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setObservers()
        binding.input.addTextChangedListener(textWatcher)
    }



    private val textWatcher = object : TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if(s?.length == 8){
                handleGetCep(s.toString())
            }
        }

        override fun afterTextChanged(s: Editable?) {

        }

    }


    private fun handleGetCep(cepNumber: String){
        viewModel.getCepWithCoroutine(cepNumber)
    }

    private fun setObservers(){
        viewModel.cepResponse.observe(this){
            binding.textResult.text = "Localidade: ${it.localidade}\nBairro: ${it.bairro}\nLogradouro: ${it.logradouro}"
        }
    }
}