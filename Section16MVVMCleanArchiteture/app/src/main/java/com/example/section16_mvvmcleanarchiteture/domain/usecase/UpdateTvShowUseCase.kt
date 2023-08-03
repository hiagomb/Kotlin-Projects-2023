package com.example.section16_mvvmcleanarchiteture.domain.usecase

import com.example.section16_mvvmcleanarchiteture.data.model.tvShow.TvShow
import com.example.section16_mvvmcleanarchiteture.domain.repository.TvShowRepository

class UpdateTvShowUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute(): List<TvShow>? = tvShowRepository.updateTbShows()
}