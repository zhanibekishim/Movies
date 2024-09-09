package com.jax.movies.presentation.movieslist.adapter

import androidx.recyclerview.widget.DiffUtil
import com.jax.movies.domain.entity.Movie

class MovieDiffCallBack:DiffUtil.ItemCallback<Movie>(){
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
}