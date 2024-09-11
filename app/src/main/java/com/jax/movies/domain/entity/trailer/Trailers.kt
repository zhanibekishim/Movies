package com.jax.movies.domain.entity.trailer

import com.jax.movies.data.network.model.trailer.TrailerDto

data class Trailers(
    val trailers: List<TrailerDto>
)