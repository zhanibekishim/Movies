package com.jax.movies.di

import android.app.Application
import com.jax.movies.presentation.movieDetail.MovieDetailActivity
import com.jax.movies.presentation.movies.MoviesActivity
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun inject(moviesActivity: MoviesActivity)
    fun inject(movieDetailActivity: MovieDetailActivity)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}