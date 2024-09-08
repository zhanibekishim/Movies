package com.jax.movies.domain.usecase

import com.jax.movies.domain.entity.Movie
import com.jax.movies.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(id: Int): Movie {
        return repository.getMovie(id)
    }
}