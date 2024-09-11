package com.jax.movies.presentation.movies.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jax.movies.R
import com.jax.movies.databinding.MovieCardBinding
import com.jax.movies.domain.entity.movie.Movie

class MovieViewHolder(private val binding: MovieCardBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: Movie){
        Glide.with(binding.root)
            .load(movie.poster.imageUrl)
            .error(R.drawable.ic_launcher_foreground)
            .into(binding.imgMovie)

        val ratingKp = movie.rating.kpRating
        val ratingImdb =  movie.rating.imdbRating

        setUpColor(getColorByRating(ratingKp),ratingKp)
        setUpColor(getColorByRating(ratingImdb),ratingImdb)
    }
    private fun getColorByRating(rating:Float):Int{
        return when (rating) {
            -1f -> android.R.color.white
            in 0f..5f -> android.R.color.holo_red_dark
            in 6f..8f -> android.R.color.holo_orange_light
            else -> android.R.color.holo_green_light
        }
    }
    private fun setUpColor(color:Int,rating: Float){
        if(color !=  android.R.color.white){
            binding.tvRatingKp.text = rating.toString()
            binding.tvRatingKp.setBackgroundColor(color)
        }
    }
}