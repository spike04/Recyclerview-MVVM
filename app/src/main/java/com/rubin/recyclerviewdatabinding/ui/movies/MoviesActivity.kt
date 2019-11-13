package com.rubin.recyclerviewdatabinding.ui.movies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rubin.recyclerviewdatabinding.R
import com.rubin.recyclerviewdatabinding.data.network.MoviesApi
import com.rubin.recyclerviewdatabinding.data.repository.MoviesRepository
import com.rubin.recyclerviewdatabinding.util.Coroutines
import com.rubin.recyclerviewdatabinding.util.toast

class MoviesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = MoviesRepository(MoviesApi())

        Coroutines.main {
            val movies = repository.getMovies()
            toast(movies.toString())
        }
    }
}
