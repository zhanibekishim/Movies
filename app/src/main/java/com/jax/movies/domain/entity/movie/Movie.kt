package com.jax.movies.domain.entity.movie

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val id: Int,
    val name: String,
    val year: Int,
    val description: String,
    val poster: Poster,
    val rating: Rating,
    val genres: List<Genres> = emptyList(),
    val countries: List<Countries> = emptyList()
):Parcelable