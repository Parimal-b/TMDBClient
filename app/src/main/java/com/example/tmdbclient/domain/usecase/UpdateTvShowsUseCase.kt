package com.example.tmdbclient.domain.usecase

import com.example.tmdbclient.data.model.tvshow.TvShow
import com.example.tmdbclient.data.repository.repository.TvRepository

class UpdateTvShowsUseCase(private val tvRepository: TvRepository) {

    suspend fun execute(): List<TvShow>? = tvRepository.updateTvShows()
}