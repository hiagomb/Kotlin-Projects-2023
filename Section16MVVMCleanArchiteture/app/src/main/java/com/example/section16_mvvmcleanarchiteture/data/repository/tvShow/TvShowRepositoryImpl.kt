package com.example.section16_mvvmcleanarchiteture.data.repository.tvShow

import com.example.section16_mvvmcleanarchiteture.data.model.tvShow.TvShow
import com.example.section16_mvvmcleanarchiteture.data.repository.tvShow.dataSource.TvShowCacheDataSource
import com.example.section16_mvvmcleanarchiteture.data.repository.tvShow.dataSource.TvShowLocalDataSource
import com.example.section16_mvvmcleanarchiteture.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import com.example.section16_mvvmcleanarchiteture.domain.repository.TvShowRepository

class TvShowRepositoryImpl(private val tvShowRemoteDataSource: TvShowRemoteDataSource,
                           private val tvShowLocalDataSource: TvShowLocalDataSource,
                           private val tvShowCacheDataSource: TvShowCacheDataSource): TvShowRepository {


    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTbShows(): List<TvShow>? {
        val tvShowsList = getTvShowsFromApi()
        tvShowCacheDataSource.saveTvShowsToCache(tvShowsList)
        tvShowLocalDataSource.deleteAll()
        tvShowLocalDataSource.saveTvShowsToDB(tvShowsList)
        return tvShowsList
    }

    suspend fun getTvShowsFromApi(): List<TvShow>{
        lateinit var tvShowList: List<TvShow>

        val response =  tvShowRemoteDataSource.getTvShow()
        val body = response.body()
        if(body != null){
            tvShowList = body.tvShows
        }
        return tvShowList
    }

    suspend fun getTvShowsFromDB(): List<TvShow>{
        var tvShowList = tvShowLocalDataSource.getTvShowsFromDB()
        if(tvShowList.size > 0){
            return tvShowList
        }
        tvShowList = getTvShowsFromApi()
        tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
        return tvShowList
    }

    suspend fun getTvShowsFromCache(): List<TvShow>{
        var tvShowList = tvShowCacheDataSource.getTvShowsFromCache()
        if(tvShowList.size > 0){
            return tvShowList
        }
        tvShowList = getTvShowsFromDB()
        tvShowCacheDataSource.saveTvShowsToCache(tvShowList)
        return tvShowList
    }
}