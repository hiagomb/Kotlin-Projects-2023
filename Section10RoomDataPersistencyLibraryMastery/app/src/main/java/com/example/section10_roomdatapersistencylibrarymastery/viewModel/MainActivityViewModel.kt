package com.example.section10_roomdatapersistencylibrarymastery.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.section10_roomdatapersistencylibrarymastery.db.Subscriber
import com.example.section10_roomdatapersistencylibrarymastery.repository.SubscriberRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {


    private val subscriberRepository =  SubscriberRepository(application.applicationContext)
    private val _subscribers = MutableLiveData<List<Subscriber>>()
    val subscribers: LiveData<List<Subscriber>> = _subscribers
    private val _id_result = MutableLiveData<Long>()
    val id_result: LiveData<Long> = _id_result

    init {
        _id_result.value = 0
    }

    fun insert(subscriber: Subscriber){
        viewModelScope.launch(Dispatchers.IO) {
            val result = subscriberRepository.insert(subscriber)
            withContext(Dispatchers.Main){
                _id_result.value = result
            }
        }
    }

    fun update(subscriber: Subscriber){
        viewModelScope.launch(Dispatchers.IO) {
            val result = subscriberRepository.update(subscriber)
            withContext(Dispatchers.Main){
                _id_result.value = result.toLong()
            }
        }
    }

    fun delete(subscriber: Subscriber){
        viewModelScope.launch(Dispatchers.IO) {
            val result = subscriberRepository.delete(subscriber)
            withContext(Dispatchers.Main){
                _id_result.value = result.toLong()
            }
        }
    }

    fun clearAll(){
        viewModelScope.launch(Dispatchers.IO) {
            val result = subscriberRepository.clearAll()
            withContext(Dispatchers.Main){
                _id_result.value = result.toLong()
            }
        }
    }

    fun getAll(){
        viewModelScope.launch(Dispatchers.IO) {
            val result = subscriberRepository.getAll()
            withContext(Dispatchers.Main){
                _subscribers.value = result
            }
        }
    }


}