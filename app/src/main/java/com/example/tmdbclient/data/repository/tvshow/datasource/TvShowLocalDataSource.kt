package com.example.tmdbclient.data.repository.tvshow.datasource

import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.model.tvshow.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDB(): List<TvShow>
    suspend fun saveTvShowsToDB(movie: List<TvShow>)
    suspend fun clearAll()
}