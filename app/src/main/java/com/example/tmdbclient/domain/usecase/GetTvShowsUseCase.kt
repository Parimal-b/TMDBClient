package com.example.tmdbclient.domain.usecase

import com.example.tmdbclient.data.model.tvshow.TvShow
import com.example.tmdbclient.domain.repository.TvRepository

class GetTvShowsUseCase(private val tvRepository: TvRepository) {
    suspend fun execute(): List<TvShow>? = tvRepository.getTvShows()
}