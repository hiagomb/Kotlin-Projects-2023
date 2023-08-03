package com.example.section20_mvvmcleanarchiteture.presentation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.section20_mvvmcleanarchiteture.R
import com.example.section20_mvvmcleanarchiteture.data.util.Resource
import com.example.section20_mvvmcleanarchiteture.databinding.FragmentNewsBinding
import com.example.section20_mvvmcleanarchiteture.presentation.adapter.RecyclerNewsAdapter
import com.example.section20_mvvmcleanarchiteture.presentation.viewModel.NewsViewModel

class NewsFragment : Fragment() {

    private lateinit var viewModel : NewsViewModel
    private lateinit var binding : FragmentNewsBinding
    private lateinit var newsAdapter: RecyclerNewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewsBinding.bind(view)
        viewModel = (activity as MainActivity).viewModel
        newsAdapter = (activity as MainActivity).newsAdapter
        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("selected_article", it)
            }
            findNavController().navigate(
                R.id.action_newsFragment_to_infoFragment, bundle
            )
        }
        binding.searchViewNews.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                if(query!= null){
                    viewModel.getSeachedTopHeadLines("us", 1, query!!)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })

        binding.searchViewNews.setOnCloseListener(object : SearchView.OnCloseListener{
            override fun onClose(): Boolean {
                viewModel.getTopHeadLines("us", 1)
                return true
            }
        })
        initRecyclerView()
        setObservers()
        viewNewsList()
    }

    private fun setObservers() {
        viewModel.newsHeadLine.observe(viewLifecycleOwner){
            when(it){
                is Resource.Success -> {
                    showOrHideProgressBar(false)
                    newsAdapter.differ.submitList(it.data?.articles)
                }
                is Resource.Error -> {
                    showOrHideProgressBar(false)
                    Toast.makeText(activity, it.message, Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading -> {
                    showOrHideProgressBar(true)
                }
            }
        }

        viewModel.searchedNewsHeadLine.observe(viewLifecycleOwner){
            when(it){
                is Resource.Success -> {
                    showOrHideProgressBar(false)
                    newsAdapter.differ.submitList(it.data?.articles)
                }
                is Resource.Error -> {
                    showOrHideProgressBar(false)
                    Toast.makeText(activity, it.message, Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading -> {
                    showOrHideProgressBar(true)
                }
            }
        }
    }

    private fun viewNewsList() {
            viewModel.getTopHeadLines("us", 1)
    }

    private fun initRecyclerView(){
        //newsAdapter = RecyclerNewsAdapter()

        binding.recyclerNews.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = newsAdapter
        }
    }

    private fun showOrHideProgressBar(show: Boolean){
        if(show){
            binding.progressBar.visibility = View.VISIBLE
        }else{
            binding.progressBar.visibility = View.GONE
        }
    }


}