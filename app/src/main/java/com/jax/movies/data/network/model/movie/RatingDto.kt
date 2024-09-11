package com.jax.movies.data.network.model.movie

import com.google.gson.annotations.SerializedName

data class RatingDto(
    @SerializedName("kp") val kpRating: Float,
    @SerializedName("imdb") val imdbRating: Float,
)