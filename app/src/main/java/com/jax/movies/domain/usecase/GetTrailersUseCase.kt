package com.jax.movies.domain.usecase

import com.jax.movies.domain.entity.trailer.Trailer
import com.jax.movies.domain.repository.MovieRepository
import javax.inject.Inject

class GetTrailersUseCase @Inject constructor(
    private val repository:MovieRepository
) {
    suspend operator fun invoke(id:Int):List<Trailer>{
        return repository.getTrailer(id)
    }
}