package com.D121211105.movie.data.repository

import com.D121211105.movie.data.models.Movie
import com.D121211105.movie.data.response.GetMovieResponse
import com.D121211105.movie.data.source.remote.ApiService

class MovieRepository(private val apiService: ApiService) {

    suspend fun getMovie(): GetMovieResponse {
        return apiService.getMovies()
    }
}