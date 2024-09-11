package com.jax.movies.presentation.movies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.jax.movies.databinding.MovieCardBinding
import com.jax.movies.domain.entity.movie.Movie


class MovieAdapter : ListAdapter<Movie, MovieViewHolder>(MovieDiffCallBack()) {

    var needToDownloadMovies: (() -> Unit)? = null
    var onMovieClickListener: ((Movie) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = MovieCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
        if (position >= itemCount - 10) {
            needToDownloadMovies?.invoke()
        }
        holder.itemView.setOnClickListener {
            onMovieClickListener?.invoke(movie)
        }
    }

    companion object {
        const val maxRecycledView = 6
        const val movieViewType = 0
    }
}