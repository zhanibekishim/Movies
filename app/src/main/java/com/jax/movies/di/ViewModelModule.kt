package com.jax.movies.di

import androidx.lifecycle.ViewModel
import com.jax.movies.presentation.movieDetail.MovieDetailViewModel
import com.jax.movies.presentation.movies.MoviesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds @IntoMap @ViewModelKey(MoviesViewModel::class)
    fun bindsMoviesListViewModel(viewModel: MoviesViewModel): ViewModel

    @Binds @IntoMap @ViewModelKey(MovieDetailViewModel::class)
    fun bindsMovieDetailViewModel(viewModel: MovieDetailViewModel): ViewModel
}