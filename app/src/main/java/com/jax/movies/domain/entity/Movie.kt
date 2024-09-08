package com.jax.movies.domain.entity

import com.jax.movies.data.network.model.CountriesDto
import com.jax.movies.data.network.model.GenresDto
import com.jax.movies.data.network.model.PosterDto
import com.jax.movies.data.network.model.RatingDto

data class Movie(
    val id: Int,
    val name: String,
    val year: Int,
    val description: String,
    val poster: PosterDto,
    val rating: RatingDto,
    val genres: List<GenresDto>,
    val countries: List<CountriesDto>
)