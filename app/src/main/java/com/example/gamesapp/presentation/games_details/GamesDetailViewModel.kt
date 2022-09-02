package com.example.gamesapp.presentation.games_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamesapp.domain.use_cases.GetGameDetailUseCase
import com.example.gamesapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class GamesDetailViewModel @Inject constructor(
    private val getGameDetailUseCase: GetGameDetailUseCase
):ViewModel() {
    private val _state = mutableStateOf(GamesDetailState())
    val state:State<GamesDetailState> = _state

    private fun getGamesDetails(id:String){
        getGameDetailUseCase(id).onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = GamesDetailState(games = result.data)
                }
                is Resource.Error -> {
                    _state.value = GamesDetailState(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading -> {
                    _state.value = GamesDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}