package com.jax.movies.data.network.api

import com.jax.movies.data.network.model.MovieResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("v1.4/movie?rating.imdb=7-10")
    suspend fun getMovies(
        @Query("page") page: Int,
        @Query("limit") limit: Int = DEFAULT_LIMIT
    ): MovieResponseDto

    private companion object {
        const val DEFAULT_LIMIT = 40
    }
}