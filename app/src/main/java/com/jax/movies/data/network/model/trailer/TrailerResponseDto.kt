package com.jax.movies.data.network.model.trailer

import com.google.gson.annotations.SerializedName

data class TrailerResponseDto(
    @SerializedName("videos") val response: TrailersDto
)
