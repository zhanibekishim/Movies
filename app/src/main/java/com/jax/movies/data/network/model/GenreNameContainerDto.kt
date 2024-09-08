package com.jax.movies.data.network.model

import com.google.gson.annotations.SerializedName

data class GenreNameContainerDto(
    @SerializedName("name") val genre: String
)