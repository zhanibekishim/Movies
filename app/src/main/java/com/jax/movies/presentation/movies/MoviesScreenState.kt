package com.jax.movies.presentation.movies

import com.jax.movies.domain.entity.movie.Movie

sealed class MoviesScreenState {

    data class Loading(val loading: Boolean) : MoviesScreenState()
    data class Error(val errorMsg: String) : MoviesScreenState()
    data class MoviesList(val movies: List<Movie>) : MoviesScreenState()
}