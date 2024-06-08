package com.example.cinemate.ui.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cinemate.data.CinemateRepository
import com.example.cinemate.model.Movie
import com.example.cinemate.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: CinemateRepository) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<Movie>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<Movie>>
        get() = _uiState

    fun getRewardById(rewardId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getMoviesById(rewardId))
        }
    }
}