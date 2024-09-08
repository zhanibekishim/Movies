package com.jax.movies.data.network.model

import com.google.gson.annotations.SerializedName

data class MovieDto(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("year") val year: Int?,
    @SerializedName("description") val description: String?,
    @SerializedName("poster") val poster: PosterDto?,
    @SerializedName("rating") val rating: RatingDto?,
    @SerializedName("genres") val genres: List<GenresDto>?,
    @SerializedName("countries") val countries: List<CountriesDto>?
)
