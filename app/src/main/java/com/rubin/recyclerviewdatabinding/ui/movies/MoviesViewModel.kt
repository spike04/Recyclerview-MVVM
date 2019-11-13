package com.rubin.recyclerviewdatabinding.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rubin.recyclerviewdatabinding.data.entities.Movie
import com.rubin.recyclerviewdatabinding.data.repository.MoviesRepository

class MoviesViewModel(val repository: MoviesRepository) : ViewModel() {
    private val _movies = MutableLiveData<List<Movie>>()

    val movies: LiveData<List<Movie>>
        get() = _movies

    suspend fun getMovies() {
        val movies = repository.getMovies()
        _movies.value = movies
    }
}
