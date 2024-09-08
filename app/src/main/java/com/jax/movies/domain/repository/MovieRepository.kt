package com.jax.movies.domain.repository

import com.jax.movies.domain.entity.Movie

interface MovieRepository {

    suspend fun getMovies(page: Int): List<Movie>
    suspend fun getMovie(id: Int): Movie
}