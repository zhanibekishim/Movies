package com.jax.movies.presentation.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jax.movies.domain.usecase.GetMoviesUseCase
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

class MoviesViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {

    private val _state = MutableLiveData<MoviesScreenState>()
    val state: LiveData<MoviesScreenState>
        get() = _state

    private var page = 1

    init {
        loadMovies()
    }

    fun loadMovies() {
        val currentState = _state.value
        if(currentState is MoviesScreenState.Loading) return
        viewModelScope.launch {
            try {
                val oldMovies = (_state.value as? MoviesScreenState.MoviesList)?.movies ?: emptyList()
                _state.value = MoviesScreenState.Loading(true)
                val newMovies = getMoviesUseCase(page++)
                val updatedMovies = oldMovies + newMovies
                _state.value = MoviesScreenState.MoviesList(updatedMovies)
            } catch (e: Exception) {
                if (e is HttpException) {
                    _state.value = MoviesScreenState.Error("HTTP Error: ${e.code()} ${e.message()}")
                } else {
                    _state.value = MoviesScreenState.Error(e.toString())
                }

            } finally {
                _state.value = MoviesScreenState.Loading(false)
            }
        }
    }
}