package com.jax.movies.data.network.model.movie

import com.google.gson.annotations.SerializedName

data class PosterDto(
    @SerializedName("url") val imageUrl:String
)