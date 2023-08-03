package com.example.section20_mvvmcleanarchiteture.domain.useCase

import com.example.section20_mvvmcleanarchiteture.data.model.TopHeadLinesResponse
import com.example.section20_mvvmcleanarchiteture.data.util.Resource
import com.example.section20_mvvmcleanarchiteture.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(country: String, page: Int, query: String): Resource<TopHeadLinesResponse>{
        return newsRepository.getSearchedNews(country, page, query)
    }
}