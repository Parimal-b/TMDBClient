package com.example.tmdbclient.presentation.di
import com.example.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.example.tmdbclient.presentation.di.tvshow.TvShowSubComponent
import com.example.tmdbclient.presentation.di.movie.MovieSubComponent

interface Injector {

    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}