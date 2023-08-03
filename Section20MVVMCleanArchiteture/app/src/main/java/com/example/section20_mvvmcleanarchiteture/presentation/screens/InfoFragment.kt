package com.example.section20_mvvmcleanarchiteture.presentation.screens

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.navArgs
import com.example.section20_mvvmcleanarchiteture.R
import com.example.section20_mvvmcleanarchiteture.data.model.Article
import com.example.section20_mvvmcleanarchiteture.data.model.Source
import com.example.section20_mvvmcleanarchiteture.databinding.FragmentInfoBinding
import com.example.section20_mvvmcleanarchiteture.databinding.FragmentNewsBinding
import com.example.section20_mvvmcleanarchiteture.presentation.viewModel.NewsViewModel
import com.google.android.material.snackbar.Snackbar


class InfoFragment : Fragment() {


    private lateinit var binding: FragmentInfoBinding
    private lateinit var viewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInfoBinding.bind(view)
        viewModel = (activity as MainActivity).viewModel

        val args: InfoFragmentArgs by navArgs()
        val article = args.selectedArticle

        binding.webViewInfo.apply {
            webViewClient = WebViewClient()
            if(article.url != null){
                loadUrl(article.url)
            }
        }
        binding.fabSave.setOnClickListener {
            viewModel.saveArticle(article)
            Snackbar.make(view, "News saved with success", Snackbar.LENGTH_SHORT).show()
        }
    }

}