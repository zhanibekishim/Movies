package com.jax.movies.data.network.model.movie

import com.google.gson.annotations.SerializedName

data class CountriesDto(
    @SerializedName("countries") val countries: List<CountryNameContainerDto>?
)