package com.jax.movies.domain.entity.movie

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Rating(
    val kpRating: Float,
    val imdbRating: Float,
) : Parcelable