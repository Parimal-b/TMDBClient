package com.example.tmdbclient.domain.usecase

import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.repository.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()
}