package com.rubin.recyclerviewdatabinding.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rubin.recyclerviewdatabinding.data.entities.Movie
import com.rubin.recyclerviewdatabinding.data.repository.MoviesRepository
import com.rubin.recyclerviewdatabinding.util.Coroutines
import kotlinx.coroutines.Job

class MoviesViewModel(private val repository: MoviesRepository) : ViewModel() {
    private val _movies = MutableLiveData<List<Movie>>()

    private lateinit var job: Job

    val movies: LiveData<List<Movie>>
        get() = _movies

    fun getMovies() {
        job = Coroutines.ioThenMain(
            { repository.getMovies() },
            { _movies.value = it }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }
}
