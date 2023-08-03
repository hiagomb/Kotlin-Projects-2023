package com.example.section16_mvvmcleanarchiteture.presentation.tvShow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.section16_mvvmcleanarchiteture.domain.usecase.GetTvShowUseCase
import com.example.section16_mvvmcleanarchiteture.domain.usecase.UpdateTvShowUseCase

class TvShowViewModel(private val getTvShowUseCase: GetTvShowUseCase,
                      private val updateTvShowUseCase: UpdateTvShowUseCase):
    ViewModel() {

        fun getTvShow() = liveData {
            val tvShowList = getTvShowUseCase.execute()
            emit(tvShowList)
        }

    fun updateTvShow() = liveData {
        val tvShowList = updateTvShowUseCase.execute()
        emit(tvShowList)
    }
}