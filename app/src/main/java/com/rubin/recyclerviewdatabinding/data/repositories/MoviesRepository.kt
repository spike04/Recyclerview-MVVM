package com.rubin.recyclerviewdatabinding.data.repositories

import com.rubin.recyclerviewdatabinding.data.network.MoviesApi
import com.rubin.recyclerviewdatabinding.data.network.SafeApiRequest

class MoviesRepository(private val api: MoviesApi) : SafeApiRequest() {

    suspend fun getMovies() = apiRequest { api.getMovies() }
}