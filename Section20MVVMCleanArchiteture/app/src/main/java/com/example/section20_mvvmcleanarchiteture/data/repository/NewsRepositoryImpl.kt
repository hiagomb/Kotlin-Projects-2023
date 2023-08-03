package com.example.section20_mvvmcleanarchiteture.data.repository

import com.example.section20_mvvmcleanarchiteture.data.model.Article
import com.example.section20_mvvmcleanarchiteture.data.model.TopHeadLinesResponse
import com.example.section20_mvvmcleanarchiteture.data.repository.dataSource.NewsLocalDataSource
import com.example.section20_mvvmcleanarchiteture.data.repository.dataSource.NewsRemoteDataSource
import com.example.section20_mvvmcleanarchiteture.data.util.Resource
import com.example.section20_mvvmcleanarchiteture.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(private val newsRemoteDataSource: NewsRemoteDataSource,
                        private val newsLocalDataSource: NewsLocalDataSource): NewsRepository {

    override suspend fun getNewsHeadlines(country: String, page: Int): Resource<TopHeadLinesResponse> {
        return convertResponseToResource(newsRemoteDataSource.getNewsRemote(country, page))
    }

    override suspend fun getSearchedNews(country: String, page: Int, query: String): Resource<TopHeadLinesResponse> {
        return convertResponseToResource(newsRemoteDataSource.getSearchedNewsRemote(country, page, query))
    }

    override suspend fun saveNews(article: Article) {
        newsLocalDataSource.insert(article)
    }

    override suspend fun deleteNews(article: Article) {
        newsLocalDataSource.delete(article)
    }

    override fun getSavedNews(): Flow<List<Article>> {
        return newsLocalDataSource.getSavedNews()
    }

    //convert from response to resource
    private fun convertResponseToResource(response: Response<TopHeadLinesResponse>)
    : Resource<TopHeadLinesResponse>{
        if(response.isSuccessful){
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(null, response.message())
    }
}