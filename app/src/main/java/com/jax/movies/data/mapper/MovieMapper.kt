package com.jax.movies.data.mapper

import com.jax.movies.data.network.model.MovieDto
import com.jax.movies.data.network.model.PosterDto
import com.jax.movies.data.network.model.RatingDto
import com.jax.movies.domain.entity.Movie
import javax.inject.Inject

class MovieMapper @Inject constructor() {

    fun dtoToEntity(movieDto: MovieDto) = Movie(
        id = movieDto.id ?: 0 ,
        name = movieDto.name ?: "",
        description = movieDto.description ?: "",
        poster = movieDto.poster ?: PosterDto(""),
        rating = movieDto.rating ?: RatingDto(0f,0f),
        year = movieDto.year ?: 2024,
        genres = movieDto.genres ?: emptyList(),
        countries = movieDto.countries ?: emptyList(),
    )

    fun dtoListToEntity(dtoList: List<MovieDto>): List<Movie> {
        return dtoList.map { dtoMovie ->
            dtoToEntity(dtoMovie)
        }
    }
}