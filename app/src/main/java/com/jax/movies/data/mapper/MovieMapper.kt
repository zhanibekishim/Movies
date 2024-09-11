package com.jax.movies.data.mapper

import com.jax.movies.data.network.model.movie.CountriesDto
import com.jax.movies.data.network.model.movie.CountryNameContainerDto
import com.jax.movies.data.network.model.movie.GenreNameContainerDto
import com.jax.movies.data.network.model.movie.GenresDto
import com.jax.movies.data.network.model.movie.MovieDto
import com.jax.movies.data.network.model.movie.PosterDto
import com.jax.movies.data.network.model.movie.RatingDto
import com.jax.movies.domain.entity.movie.Countries
import com.jax.movies.domain.entity.movie.CountryNameContainer
import com.jax.movies.domain.entity.movie.GenreNameContainer
import com.jax.movies.domain.entity.movie.Genres
import com.jax.movies.domain.entity.movie.Movie
import com.jax.movies.domain.entity.movie.Poster
import com.jax.movies.domain.entity.movie.Rating
import javax.inject.Inject


class MovieMapper @Inject constructor() {

    private fun dtoToEntity(movieDto: MovieDto) = Movie(
        id = movieDto.id ?: 0,
        name = movieDto.name ?: "",
        description = movieDto.description ?: "",
        poster = movieDto.poster?.let { posterDtoToEntity(it) } ?: Poster(""),
        rating = movieDto.rating?.let { ratingDtoToEntity(it) } ?: Rating(0f, 0f),
        year = movieDto.year ?: 2024,
        genres = movieDto.genres?.let { genresListDtoToEntity(it) } ?: emptyList(),
        countries = movieDto.countries?.let { countriesListDtoToEntity(it) } ?: emptyList()
    )

    fun dtoListToEntity(dtoList: List<MovieDto>): List<Movie> {
        return dtoList.map { dtoMovie ->
            dtoToEntity(dtoMovie)
        }
    }

    private fun posterDtoToEntity(posterDto: PosterDto) = Poster(posterDto.imageUrl)

    private fun ratingDtoToEntity(ratingDto: RatingDto) =
        Rating(ratingDto.kpRating, ratingDto.imdbRating)

    private fun genresListDtoToEntity(genresDtoList: List<GenresDto>): List<Genres> {
        return genresDtoList.map {
            genresDtoToEntity(it)
        }
    }

    private fun genresDtoToEntity(genresDto: GenresDto): Genres {
        val genresNames = genresDto.genres?.map { name ->
            genresNameContainerDtoToEntity(name)
        } ?: emptyList()
        return Genres(genresNames)
    }

    private fun genresNameContainerDtoToEntity(genreNameContainerDto: GenreNameContainerDto): GenreNameContainer {
        val genreName = genreNameContainerDto.genre ?: ""
        return GenreNameContainer(genreName)
    }

    private fun countriesListDtoToEntity(countryListDto: List<CountriesDto>): List<Countries>{
        return countryListDto.map {
            countriesDtoToEntity(it)
        }
    }

    private fun countriesDtoToEntity(countriesDto: CountriesDto): Countries {
        val countriesName = countriesDto.countries?.map { name ->
            countryNameDtoToEntity(name)
        }?: emptyList()
        return Countries(countriesName)
    }

    private fun countryNameDtoToEntity(countryNameContainerDto: CountryNameContainerDto): CountryNameContainer {
        val countryName = countryNameContainerDto.countryName ?: ""
        return CountryNameContainer(countryName)
    }
}