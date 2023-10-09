package com.example.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbclient.domain.usecase.GetArtistUserCase
import com.example.tmdbclient.domain.usecase.UpdateArtistUserCase

class ArtistViewModelFactory(
    private val getArtistsUseCase: GetArtistUserCase,
    private val updateArtistsUseCase: UpdateArtistUserCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistsUseCase, updateArtistsUseCase) as T
    }
}