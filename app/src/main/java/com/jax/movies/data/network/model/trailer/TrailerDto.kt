package com.jax.movies.data.network.model.trailer

import com.google.gson.annotations.SerializedName

data class TrailerDto(
    @SerializedName("url") val trailerUrl: String?,
    @SerializedName("name") val trailerName: String?
)