package com.example.tmdbclient.data.repository.tvshow

import android.util.Log
import com.example.tmdbclient.data.model.tvshow.TvShow
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.tmdbclient.domain.repository.TvRepository

class TvshowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
): TvRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShows = getTvShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowsToCache(newListOfTvShows)
        return newListOfTvShows
    }

    suspend fun getTvShowsFromAPI(): List<TvShow>{
        lateinit var tvShowList: List<TvShow>
        try {
            val response = tvShowRemoteDataSource.getTvShows()
            val body = response?.body()
            if (body != null){
                tvShowList = body.tvShows!!
            }
        }catch (exception: Exception){
            Log.i("MYTAG",exception.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowssFromDB(): List<TvShow>{
        lateinit var tvShowsList: List<TvShow>
        try {
            tvShowsList = tvShowLocalDataSource.getTvShowsFromDB()
        }catch (exception: Exception){
            Log.i("MYTAG",exception.toString())
        }
        if (tvShowsList.size>0){
            return tvShowsList
        }else{
            tvShowsList = getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowsList)
        }
        return tvShowsList
    }

    suspend fun getTvShowsFromCache(): List<TvShow>{
        lateinit var tvShowsList: List<TvShow>
        try {
            tvShowsList = tvShowCacheDataSource.getTvShowsFromCache()
        }catch (exception: Exception){
            Log.i("MYTAG",exception.toString())
        }
        if (tvShowsList.size>0){
            return tvShowsList
        }else{
            tvShowsList = getTvShowssFromDB()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowsList)
        }
        return tvShowsList
    }
}