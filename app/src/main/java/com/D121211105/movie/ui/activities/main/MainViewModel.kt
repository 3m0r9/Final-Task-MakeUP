package com.D121211105.movie.ui.activities.main

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.D121211105.movie.MyApplication
import com.D121211105.movie.data.models.Movie
import com.D121211105.movie.data.repository.MovieRepository
import kotlinx.coroutines.launch

sealed interface MainUiState {
    data class Success(val movies: List<Movie>) : MainUiState
    data class Error(val errorMessage: String) : MainUiState
    object Loading : MainUiState
}

class MainViewModel(private val movieRepository: MovieRepository): ViewModel() {

    var mainUiState: MainUiState by mutableStateOf(MainUiState.Loading)
        private set

    fun getMovie() = viewModelScope.launch {
        mainUiState = MainUiState.Loading
        try {
            val result = movieRepository.getMovie()
            mainUiState = MainUiState.Success(result.results.orEmpty())
        } catch (e: Exception) {
            Log.e("MainViewModel", "Error fetching makeup", e)
            mainUiState = MainUiState.Error(errorMessage = "Failed to fetch makeup data")
        }
    }

    init {
        getMovie()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MyApplication)
                val movieResponse = application.container.movieRepository
                MainViewModel(movieResponse)
            }
        }
    }

}