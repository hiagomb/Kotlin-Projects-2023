package com.example.section16_mvvmcleanarchiteture.data.repository.tvShow.dataSourceImpl

import com.example.section16_mvvmcleanarchiteture.data.db.TvShowDAO
import com.example.section16_mvvmcleanarchiteture.data.model.people.People
import com.example.section16_mvvmcleanarchiteture.data.model.tvShow.TvShow
import com.example.section16_mvvmcleanarchiteture.data.repository.tvShow.dataSource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDAO: TvShowDAO): TvShowLocalDataSource {

    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvShowDAO.getTvShows()
    }

    override suspend fun saveTvShowsToDB(tvShowList: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDAO.saveTvShows(tvShowList)
        }
    }

    override suspend fun deleteAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDAO.deleteAllTvShows()
        }
    }
}