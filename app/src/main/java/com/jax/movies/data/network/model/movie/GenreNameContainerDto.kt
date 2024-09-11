package com.jax.movies.data.network.model.movie

import com.google.gson.annotations.SerializedName

data class GenreNameContainerDto(
    @SerializedName("name") val genre: String?
)