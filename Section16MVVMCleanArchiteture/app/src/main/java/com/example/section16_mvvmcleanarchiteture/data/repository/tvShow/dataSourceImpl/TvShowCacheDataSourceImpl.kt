package com.example.section16_mvvmcleanarchiteture.data.repository.tvShow.dataSourceImpl

import com.example.section16_mvvmcleanarchiteture.data.model.tvShow.TvShow
import com.example.section16_mvvmcleanarchiteture.data.repository.tvShow.dataSource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl: TvShowCacheDataSource {

    private var tvShowList = ArrayList<TvShow>()

    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsToCache(tvShowList: List<TvShow>) {
        this.tvShowList = tvShowList as ArrayList<TvShow>
    }
}