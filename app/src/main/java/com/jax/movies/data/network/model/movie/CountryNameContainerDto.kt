package com.jax.movies.data.network.model.movie

import com.google.gson.annotations.SerializedName

class CountryNameContainerDto(
    @SerializedName("name") val countryName: String?
)