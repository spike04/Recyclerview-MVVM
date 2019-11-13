package com.rubin.recyclerviewdatabinding.data.network

import com.rubin.recyclerviewdatabinding.data.entities.Movie
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.simplifiedcoding.in/course-apis/recyclerview/"
private const val MOVIES = "movies"

interface MoviesApi {

    @GET(MOVIES)
    suspend fun getMovies(): Response<List<Movie>>

    companion object {
        operator fun invoke(): MoviesApi {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MoviesApi::class.java)
        }
    }
}