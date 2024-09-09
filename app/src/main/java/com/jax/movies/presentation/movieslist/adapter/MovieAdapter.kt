package com.jax.movies.presentation.movieslist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.jax.movies.databinding.MovieCardBinding
import com.jax.movies.domain.entity.Movie


class MovieAdapter : ListAdapter<Movie, MovieViewHolder>(MovieDiffCallBack()) {

    var needToDownloadMovies: (() -> Unit)? = null

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
    }

    companion object {
        const val maxRecycledView = 6
        const val movieViewType = 0
    }
}