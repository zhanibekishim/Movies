package com.jax.movies.data.repository

import com.jax.movies.data.mapper.MovieMapper
import com.jax.movies.data.network.api.MovieService
import com.jax.movies.domain.entity.Movie
import com.jax.movies.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val mapper: MovieMapper,
    private val movieService: MovieService
) : MovieRepository {

    override suspend fun getMovies(page: Int): List<Movie> {
        return mapper.dtoListToEntity(movieService.getMovies(page).movies)
    }

    override suspend fun getMovie(id: Int): Movie {
        TODO("Not yet implemented")
    }
}