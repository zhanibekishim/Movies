package com.jax.movies.data.network.model

import com.google.gson.annotations.SerializedName

data class GenresDto(
    @SerializedName("genres") val genres: List<GenreNameContainerDto>
)