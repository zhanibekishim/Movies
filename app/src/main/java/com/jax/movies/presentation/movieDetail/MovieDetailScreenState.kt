package com.jax.movies.presentation.movieDetail

import com.jax.movies.domain.entity.trailer.Trailer

sealed class MovieDetailScreenState {

    data class Loading(val loading: Boolean) : MovieDetailScreenState()
    data class Error(val errorMsg: String) : MovieDetailScreenState()
    data class Data(val trailers: List<Trailer>) : MovieDetailScreenState()
}