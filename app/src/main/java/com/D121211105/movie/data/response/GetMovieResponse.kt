package com.D121211105.movie.data.response

import com.D121211105.movie.data.models.Movie
import kotlinx.serialization.Serializable

@Serializable
data class GetMovieResponse(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)