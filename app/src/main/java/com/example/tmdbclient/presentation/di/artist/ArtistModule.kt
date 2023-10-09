package com.example.tmdbclient.presentation.di.artist

import com.example.tmdbclient.domain.usecase.GetArtistUserCase
import com.example.tmdbclient.domain.usecase.UpdateArtistUserCase
import com.example.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistUserCase,
        updateArtistsUseCase: UpdateArtistUserCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            getArtistsUseCase,
            updateArtistsUseCase
        )
    }
}