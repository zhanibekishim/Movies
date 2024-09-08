package com.jax.movies.di

import androidx.lifecycle.ViewModel
import com.jax.movies.presentation.movieslist.MoviesListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds @IntoMap @ViewModelKey(MoviesListViewModel::class)
    fun bindsMoviesListViewModel(viewModel: MoviesListViewModel): ViewModel
}