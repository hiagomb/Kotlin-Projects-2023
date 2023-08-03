package com.example.section10_roomdatapersistencylibrarymastery.repository

import android.content.Context
import com.example.section10_roomdatapersistencylibrarymastery.db.MyDB
import com.example.section10_roomdatapersistencylibrarymastery.db.Subscriber
import com.example.section10_roomdatapersistencylibrarymastery.db.SubscriberDAO

class SubscriberRepository(context: Context) {

    val dao = MyDB.getInstance(context).getSubscriberDAO()

    suspend fun insert(subscriber: Subscriber): Long{
        return dao.insert(subscriber)
    }

    suspend fun delete(subscriber: Subscriber): Int{
        return dao.delete(subscriber)
    }

    suspend fun update(subscriber: Subscriber): Int{
        return dao.update(subscriber)
    }

    suspend fun getAll(): List<Subscriber>{
        return dao.getAll()
    }

    suspend fun clearAll(): Int{
        return dao.clearAll()
    }


}