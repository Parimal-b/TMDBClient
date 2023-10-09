package com.example.tmdbclient.domain.usecase

import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.domain.repository.ArtistRepository

class UpdateArtistUserCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.updateArtists()
}