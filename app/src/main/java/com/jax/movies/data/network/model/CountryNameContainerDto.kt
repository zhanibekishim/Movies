package com.jax.movies.data.network.model

import com.google.gson.annotations.SerializedName

class CountryNameContainerDto(
    @SerializedName("name") val countryName: String
)