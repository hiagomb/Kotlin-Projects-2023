package com.example.section20_mvvmcleanarchiteture.data.db

import androidx.room.TypeConverter
import com.example.section20_mvvmcleanarchiteture.data.model.Source


class Converters {

    @TypeConverter
    fun fromSource(source: Source): String{
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source{
        return Source(name, name)
    }
}