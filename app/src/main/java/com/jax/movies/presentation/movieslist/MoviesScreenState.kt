package com.jax.movies.presentation.movieslist

import com.jax.movies.domain.entity.Movie

sealed class MoviesScreenState {

    data class Loading(val loading: Boolean) : MoviesScreenState()
    data class Error(val errorMsg: String) : MoviesScreenState()
    data class MoviesList(val movies: List<Movie>) : MoviesScreenState()
}