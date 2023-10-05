package com.example.tmdbclient.domain.usecase

import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.repository.repository.ArtistRepository

class GetArtistUserCase(private val repository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = repository.getArtists()
}