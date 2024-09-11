package com.jax.movies.domain.usecase

import com.jax.movies.domain.entity.movie.Movie
import com.jax.movies.domain.repository.MovieRepository
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(page: Int): List<Movie> {
        return repository.getMovies(page)
    }
}