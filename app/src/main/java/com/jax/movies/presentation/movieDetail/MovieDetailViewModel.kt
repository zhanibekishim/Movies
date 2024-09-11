package com.jax.movies.presentation.movieDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jax.movies.domain.usecase.GetTrailersUseCase
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(
    private val getTrailersUseCase: GetTrailersUseCase
):ViewModel() {

    private val _state = MutableLiveData<MovieDetailScreenState>()
    val state:LiveData<MovieDetailScreenState>
        get() = _state


    fun loadTrailers(id:Int){
        viewModelScope.launch {
            try {
                _state.value = MovieDetailScreenState.Loading(true)
                val trailers = getTrailersUseCase(id)
                _state.value = MovieDetailScreenState.Data(trailers)
            }catch (e:Exception){
                if (e is HttpException) {
                    _state.value = MovieDetailScreenState.Error("HTTP Error: ${e.code()} ${e.message()}")
                } else {
                    _state.value = MovieDetailScreenState.Error(e.toString())
                }
            }finally {
                _state.value = MovieDetailScreenState.Loading(false)
            }

        }
    }
}