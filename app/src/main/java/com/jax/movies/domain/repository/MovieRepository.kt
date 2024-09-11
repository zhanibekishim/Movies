package com.jax.movies.domain.repository

import com.jax.movies.domain.entity.movie.Movie
import com.jax.movies.domain.entity.trailer.Trailer

interface MovieRepository {

    suspend fun getMovies(page: Int): List<Movie>
    suspend fun getMovie(id: Int): Movie
    suspend fun getTrailer(id: Int): List<Trailer>
}