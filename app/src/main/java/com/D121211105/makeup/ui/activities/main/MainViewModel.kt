package com.D121211105.makeup.ui.activities.main

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.D121211105.makeup.MyApplication
import com.D121211105.makeup.data.models.Makeup
import com.D121211105.makeup.data.repository.MakeupRepository
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface MainUiState {
    data class Success(val makeup: List<Makeup>) : MainUiState
    data class Error(val errorMessage: String) : MainUiState
    object Loading : MainUiState
}

class MainViewModel(private val makeupRepository: MakeupRepository): ViewModel() {

    var mainUiState: MainUiState by mutableStateOf(MainUiState.Loading)
        private set

//    fun getMakeup() = viewModelScope.launch {
//        mainUiState = MainUiState.Loading
//        try {
//            val result = makeupRepository.getMakeup()
//            mainUiState = MainUiState.Success(result.makeup.orEmpty())
//        } catch (e: IOException) {
//            mainUiState = MainUiState.Error(e.message.orEmpty())
//        }
//    }

    fun getMakeup() = viewModelScope.launch {
        mainUiState = MainUiState.Loading
        try {
            val result = makeupRepository.getMakeup()
            mainUiState = MainUiState.Success(result.makeup.orEmpty())
        } catch (e: Exception) {
            Log.e("MainViewModel", "Error fetching makeup", e)
            mainUiState = MainUiState.Error(errorMessage = "Failed to fetch makeup data")
        }
    }

    init {
        getMakeup()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MyApplication)
                val makeupResponse = application.container.makeupRepository
                MainViewModel(makeupResponse)
            }
        }
    }

}