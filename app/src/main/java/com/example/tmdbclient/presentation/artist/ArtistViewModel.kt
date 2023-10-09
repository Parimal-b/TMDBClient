package com.example.tmdbclient.presentation.artist


import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.domain.usecase.GetArtistUserCase
import com.example.tmdbclient.domain.usecase.UpdateArtistUserCase
class ArtistViewModel(
    private val getArtistsUseCase: GetArtistUserCase,
    private val updateArtistsUseCase: UpdateArtistUserCase
): ViewModel() {

    fun getArtist() = liveData {
        val artistList = getArtistsUseCase.execute()
        emit(artistList)
    }

    fun updateArtist() = liveData {
        val artistList = updateArtistsUseCase.execute()
        emit(artistList)
    }
}