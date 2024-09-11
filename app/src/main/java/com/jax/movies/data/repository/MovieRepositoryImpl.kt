package com.jax.movies.data.repository

import android.util.Log
import com.jax.movies.data.mapper.MovieMapper
import com.jax.movies.data.mapper.TrailerMapper
import com.jax.movies.data.network.api.MovieService
import com.jax.movies.domain.entity.movie.Movie
import com.jax.movies.domain.entity.trailer.Trailer
import com.jax.movies.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieService: MovieService,
    private val movieMapper: MovieMapper,
    private val trailerMapper: TrailerMapper
) : MovieRepository {

    override suspend fun getMovies(page: Int): List<Movie> {
        return movieMapper.dtoListToEntity(movieService.getMovies(page).movies)
    }

    override suspend fun getTrailer(id: Int): List<Trailer> {
        try {
            Log.d("dsamndsajjdsa",movieService.getTrailer(id).toString())
            return trailerMapper.dtoListToEntity(movieService.getTrailer(id).response.trailers)
        }catch (e:Exception){
            Log.d("dsamndsajjdsa",e.message.toString())
        }
        return emptyList()
    }

    override suspend fun getMovie(id: Int): Movie {
        TODO("Not yet implemented")
    }
}