package com.jax.movies.domain.entity.movie

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Countries(
    val countries: List<CountryNameContainer>
): Parcelable