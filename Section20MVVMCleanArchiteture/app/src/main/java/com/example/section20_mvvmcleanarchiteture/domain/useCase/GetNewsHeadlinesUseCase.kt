package com.example.section20_mvvmcleanarchiteture.domain.useCase

import com.example.section20_mvvmcleanarchiteture.data.model.TopHeadLinesResponse
import com.example.section20_mvvmcleanarchiteture.data.util.Resource
import com.example.section20_mvvmcleanarchiteture.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(country: String, page: Int): Resource<TopHeadLinesResponse>{
        return newsRepository.getNewsHeadlines(country, page)
    }
}