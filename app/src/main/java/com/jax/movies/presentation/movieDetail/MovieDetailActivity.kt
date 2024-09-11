package com.jax.movies.presentation.movieDetail

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.jax.movies.R
import com.jax.movies.databinding.ActivityMovieDetailBinding
import com.jax.movies.domain.entity.movie.Movie
import com.jax.movies.presentation.MovieApp
import com.jax.movies.presentation.ViewModelFactory
import javax.inject.Inject

class MovieDetailActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[MovieDetailViewModel::class.java]
    }
    private val binding by lazy {
        ActivityMovieDetailBinding.inflate(layoutInflater)
    }
    private val component by lazy {
        (application as MovieApp).component
    }
    private lateinit var movie: Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        parseIntent()
        bindViews()
        observeViewModel()
        viewModel.loadTrailers(movie.id)
    }

    private fun bindViews() {
        with(binding) {
            Glide.with(this@MovieDetailActivity)
                .load(movie.poster.imageUrl)
                .error(R.drawable.ic_launcher_foreground)
                .into(imgMovie)
            tvTitle.text = movie.name
            tvYear.text = movie.year.toString()
            tvDescription.text = movie.description
        }
    }

    private fun observeViewModel(){
        viewModel.state.observe(this){
            when(it){
                is MovieDetailScreenState.Data -> {
                    Log.d("sadmasjdjaskmjdsam",it.trailers.toString())
                }
                is MovieDetailScreenState.Error -> {
                    Log.d("dsamndsajjdsa",it.errorMsg)
                    Toast.makeText(this,ERROR,Toast.LENGTH_SHORT).show()
                }
                is MovieDetailScreenState.Loading -> {

                }
            }
        }
    }

    @SuppressLint("NewApi")
    private fun parseIntent() {
        movie = intent.getParcelableExtra(EXTRA_MOVIE)
            ?: throw RuntimeException("Movie parameter not found")
    }

    companion object {
        private const val ERROR = "Happened some issue"
        private const val EXTRA_MOVIE = "extra_movie"
        fun newIntent(context: Context, movie: Movie): Intent {
            return Intent(context, MovieDetailActivity::class.java).apply {
                putExtra(EXTRA_MOVIE, movie)
            }
        }
    }
}