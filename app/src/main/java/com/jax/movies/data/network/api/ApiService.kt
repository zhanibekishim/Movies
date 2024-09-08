package com.jax.movies.data.network.api

import com.jax.movies.data.network.model.MovieResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v1.4/movie")
    suspend fun getMovies(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): MovieResponseDto

}