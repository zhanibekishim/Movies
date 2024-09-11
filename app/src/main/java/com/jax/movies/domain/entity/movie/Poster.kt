package com.jax.movies.domain.entity.movie

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Poster(
    val imageUrl: String
) : Parcelable