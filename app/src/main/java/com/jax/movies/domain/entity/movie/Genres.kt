package com.jax.movies.domain.entity.movie

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Genres(
    val genres: List<GenreNameContainer>
) : Parcelable