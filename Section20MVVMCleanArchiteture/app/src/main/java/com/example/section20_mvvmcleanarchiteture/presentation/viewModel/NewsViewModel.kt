package com.example.section20_mvvmcleanarchiteture.presentation.viewModel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.*
import com.example.section20_mvvmcleanarchiteture.data.model.Article
import com.example.section20_mvvmcleanarchiteture.data.model.TopHeadLinesResponse
import com.example.section20_mvvmcleanarchiteture.data.util.Resource
import com.example.section20_mvvmcleanarchiteture.domain.useCase.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class NewsViewModel(private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
                    private val getSearchedNewsUseCase: GetSearchedNewsUseCase,
                    private val saveNewsUseCase: SaveNewsUseCase,
                    private val getSavedNewsUseCase: GetSavedNewsUseCase,
                    private val deleteSavedNewsUseCase: DeleteSavedNewsUseCase,
                    @get:JvmName("getViewModelContext") private val application: Application): AndroidViewModel(application) {

    private val _newsHeadLine = MutableLiveData<Resource<TopHeadLinesResponse>>()
    val newsHeadLine: LiveData<Resource<TopHeadLinesResponse>> = _newsHeadLine

    fun getTopHeadLines(country: String, page: Int){
        _newsHeadLine.value = Resource.Loading()
        try{
            if(isInternetAvailable(application.applicationContext)){
                viewModelScope.launch(Dispatchers.IO) {
                    val response = getNewsHeadlinesUseCase.execute(country, page)
                    _newsHeadLine.postValue(response)
                }
            }else{
                _newsHeadLine.value = Resource.Error(null, "Internet not available")
            }
        }catch(e: java.lang.Exception){
            _newsHeadLine.value = Resource.Error(null, e.message.toString())
        }
    }


    private val _searchedNewsHeadLine = MutableLiveData<Resource<TopHeadLinesResponse>>()
    val searchedNewsHeadLine: LiveData<Resource<TopHeadLinesResponse>> = _searchedNewsHeadLine

    fun getSeachedTopHeadLines(country: String, page: Int, query: String){
        _searchedNewsHeadLine.value = Resource.Loading()
        try{
            if(isInternetAvailable(application.applicationContext)){
                viewModelScope.launch(Dispatchers.IO) {
                    val response = getSearchedNewsUseCase.execute(country, page, query)
                    _searchedNewsHeadLine.postValue(response)
                }
            }else{
                _searchedNewsHeadLine.value = Resource.Error(null, "Internet not available")
            }
        }catch(e: java.lang.Exception){
            e.printStackTrace()
        }
    }

    @Suppress("DEPRECATION")
    private fun isInternetAvailable(context: Context): Boolean {
        var result = false
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            cm?.run {
                cm.getNetworkCapabilities(cm.activeNetwork)?.run {
                    result = when {
                        hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                        hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                        hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                        else -> false
                    }
                }
            }
        } else {
            cm?.run {
                cm.activeNetworkInfo?.run {
                    if (type == ConnectivityManager.TYPE_WIFI) {
                        result = true
                    } else if (type == ConnectivityManager.TYPE_MOBILE) {
                        result = true
                    }
                }
            }
        }
        return result
    }


    fun saveArticle(article: Article){
        viewModelScope.launch(Dispatchers.IO) {
            saveNewsUseCase.execute(article)
        }
    }

    fun getSavedNews() = liveData{
            getSavedNewsUseCase.execute().collect{
                emit(it)
            }
    }

    fun deleteSavedArticle(article: Article){
        viewModelScope.launch {
            deleteSavedNewsUseCase.execute(article)
        }
    }


}





class NewsViewModelFactory(private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
                           private val getSearchedNewsUseCase: GetSearchedNewsUseCase,
                           private val saveNewsUseCase: SaveNewsUseCase,
                           private val getSavedNewsUseCase: GetSavedNewsUseCase,
                           private val deleteSavedNewsUseCase: DeleteSavedNewsUseCase,
                           private val application: Application): ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(getNewsHeadlinesUseCase, getSearchedNewsUseCase,
            saveNewsUseCase, getSavedNewsUseCase, deleteSavedNewsUseCase, application) as T
    }

}