package com.example.tmdbclient.data.repository.repository

import com.example.tmdbclient.data.model.tvshow.TvShow

interface TvRepository {

    suspend fun getTvShows(): List<TvShow>?

    suspend fun updateTvShows(): List<TvShow>?
}