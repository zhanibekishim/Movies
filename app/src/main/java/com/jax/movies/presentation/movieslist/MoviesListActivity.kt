package com.jax.movies.presentation.movieslist

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.jax.movies.R
import com.jax.movies.databinding.ActivityMoviesListBinding
import com.jax.movies.presentation.MovieApp
import com.jax.movies.presentation.ViewModelFactory
import com.jax.movies.presentation.movieslist.adapter.MovieAdapter
import javax.inject.Inject

class MoviesListActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[MoviesListViewModel::class.java]
    }
    private val binding by lazy {
        ActivityMoviesListBinding.inflate(layoutInflater)
    }
    private val component by lazy {
        (application as MovieApp).component
    }
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setUpViews()
        observeViewModel()
    }

    private fun setUpViews() {
        with(binding.rvMovies) {
            movieAdapter = MovieAdapter()
            adapter = movieAdapter
            layoutManager = GridLayoutManager(context,SPAN_COUNT)
            recycledViewPool.setMaxRecycledViews(
                MovieAdapter.movieViewType,
                MovieAdapter.maxRecycledView
            )
        }
        movieAdapter.needToDownloadMovies = {
            viewModel.loadMovies()
        }
    }

    private fun observeViewModel() {
        viewModel.state.observe(this) {
            when (it) {
                is MoviesScreenState.Error -> {
                    Log.d(LOG_TAG, it.errorMsg)
                    Toast.makeText(this, ERROR_MSG, Toast.LENGTH_SHORT).show()
                }

                is MoviesScreenState.Loading -> {
                    binding.pbLoading.visibility = if (it.loading) View.VISIBLE else View.GONE
                }

                is MoviesScreenState.MoviesList -> {
                    Log.d(LOG_TAG, it.movies.toString())
                    movieAdapter.submitList(it.movies)
                }
            }
        }
    }

    private companion object {
        const val ERROR_MSG = "Happened some issue"
        const val LOG_TAG = "LOG_TAG"
        const val SPAN_COUNT = 2
    }
}