package com.example.section10_roomdatapersistencylibrarymastery.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Subscriber::class], version = 1)
abstract class MyDB: RoomDatabase() {

    abstract fun getSubscriberDAO(): SubscriberDAO
    companion object{
        @Volatile
        private var instance: MyDB? = null
        fun getInstance(context: Context): MyDB{
            synchronized(this){
                if(instance == null){
                    instance = Room.databaseBuilder(context.applicationContext,
                        MyDB::class.java, "my_database").build()
                }
                return instance!!
            }

        }
    }
}