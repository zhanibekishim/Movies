package com.jax.movies.presentation.movieslist

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.jax.movies.R
import com.jax.movies.presentation.MovieApp
import com.jax.movies.presentation.ViewModelFactory
import javax.inject.Inject

class MoviesListActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this,viewModelFactory)[MoviesListViewModel::class.java]
    }

    private val component by lazy {
        (application as MovieApp).component
    }

    private val page = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_list)
        viewModel.movies.observe(this) { movieList ->
            Log.d("fetched data", movieList.toString())
        }
        viewModel.loadMovies(page)
    }
}