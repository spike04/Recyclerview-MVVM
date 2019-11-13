package com.rubin.recyclerviewdatabinding.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rubin.recyclerviewdatabinding.R
import com.rubin.recyclerviewdatabinding.data.models.Movie
import com.rubin.recyclerviewdatabinding.databinding.ItemMovieBinding

class MoviesAdapter(
    private val movies: List<Movie>
) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    override fun getItemCount() = movies.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MoviesViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_movie,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.itemMovieBiding.movie = movies[position]
    }

    inner class MoviesViewHolder(
        val itemMovieBiding: ItemMovieBinding
    ) : RecyclerView.ViewHolder(itemMovieBiding.root)
}