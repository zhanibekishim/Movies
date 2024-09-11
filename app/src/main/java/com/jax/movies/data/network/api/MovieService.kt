package com.jax.movies.data.network.api

import com.jax.movies.data.network.model.movie.MovieResponseDto
import com.jax.movies.data.network.model.trailer.TrailerResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("v1.4/movie?rating.kp=0-10")
    suspend fun getMovies(
        @Query("page") page: Int,
        @Query("limit") limit: Int = DEFAULT_LIMIT
    ): MovieResponseDto

    @GET("v1.4/movie")
    suspend fun getTrailer(
        @Query("id") id: Int
    ): TrailerResponseDto

    private companion object {
        const val DEFAULT_LIMIT = 40
    }
}