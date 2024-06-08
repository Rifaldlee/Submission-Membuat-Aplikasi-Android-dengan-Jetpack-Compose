package com.example.cinemate.ui.model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cinemate.data.CinemateRepository
import com.example.cinemate.model.Movie
import com.example.cinemate.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: CinemateRepository) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<Movie>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<Movie>>>
        get() = _uiState

    fun getAllMovies() {
        viewModelScope.launch {
            repository.getMovies()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { Movies ->
                    _uiState.value = UiState.Success(Movies)
                }
        }
    }

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    fun search(newQuery: String) {
        _query.value = newQuery
        val searchResult = repository.searchMovie(_query.value)
            .sortedBy { it.title }
        _uiState.value = UiState.Success(searchResult)
    }

}