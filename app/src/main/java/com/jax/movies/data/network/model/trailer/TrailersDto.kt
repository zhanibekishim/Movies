package com.jax.movies.data.network.model.trailer

import com.google.gson.annotations.SerializedName

data class TrailersDto(
    @SerializedName("trailers") val trailers: List<TrailerDto>?
)