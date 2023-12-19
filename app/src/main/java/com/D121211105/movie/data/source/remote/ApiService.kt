package com.D121211105.movie.data.source.remote


import com.D121211105.movie.data.response.GetMovieResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface ApiService {
    @Headers(
        "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJkNTg0YzA4Y2JiM2ZlMWRiYzA4YjU3MjIxY2ViZjUzMSIsInN1YiI6IjY1ODE5YmVhYWM2MTdjMDkwOTE0OWEzMCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.e0FCoi54fVgn1PJW8q3-Z22hisK8GLTox8PZBjwMqXg"
    )
    @GET("3/movie/popular")
    suspend fun getMovies(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1,) : GetMovieResponse
}