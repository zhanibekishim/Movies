package com.jax.movies.data.network.model

import com.google.gson.annotations.SerializedName

data class PosterDto(
    @SerializedName("url") val imageUrl:String
)