package com.jax.movies.di

import com.jax.movies.data.network.api.MovieFactory
import com.jax.movies.data.network.api.MovieService
import com.jax.movies.data.repository.MovieRepositoryImpl
import com.jax.movies.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindMovieRepository(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository
    companion object {
        @ApplicationScope
        @Provides
        fun providesApiService(): MovieService {
            return MovieFactory.movieService
        }
    }
}