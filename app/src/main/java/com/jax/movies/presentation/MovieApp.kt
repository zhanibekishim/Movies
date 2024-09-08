package com.jax.movies.presentation

import android.app.Application
import com.jax.movies.di.ApplicationScope
import com.jax.movies.di.DaggerApplicationComponent


class MovieApp: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}