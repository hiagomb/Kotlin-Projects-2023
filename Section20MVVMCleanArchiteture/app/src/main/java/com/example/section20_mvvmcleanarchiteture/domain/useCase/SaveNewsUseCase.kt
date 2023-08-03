package com.example.section20_mvvmcleanarchiteture.domain.useCase

import com.example.section20_mvvmcleanarchiteture.data.model.Article
import com.example.section20_mvvmcleanarchiteture.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(article: Article){
        newsRepository.saveNews(article)
    }
}