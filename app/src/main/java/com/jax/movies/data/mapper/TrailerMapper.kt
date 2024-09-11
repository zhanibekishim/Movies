package com.jax.movies.data.mapper

import com.jax.movies.data.network.model.trailer.TrailerDto
import com.jax.movies.domain.entity.trailer.Trailer
import javax.inject.Inject

class TrailerMapper @Inject constructor() {

    fun dtoListToEntity(trailerDtoList: List<TrailerDto>?): List<Trailer> {
        val trailerList = trailerDtoList?.map {
            dtoToEntity(it)
        } ?: emptyList()
        return trailerList
    }

    private fun dtoToEntity(trailerDto: TrailerDto): Trailer {
        val url = trailerDto.trailerUrl ?: ""
        val name = trailerDto.trailerName ?: ""
        return Trailer(url, name)
    }
}