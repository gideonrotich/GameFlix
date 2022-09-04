package com.example.gamesapp.presentation.games


import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.palette.graphics.Palette
import com.example.gamesapp.domain.use_cases.GetGamesUseCase
import com.example.gamesapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class GamesViewModel @Inject constructor(
    private val getGamesUseCase: GetGamesUseCase
):ViewModel() {
    private val _state = mutableStateOf(GamesState())
    val state: State<GamesState> = _state

    init {
        getGames()
    }

    private fun getGames(){
        getGamesUseCase().onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = GamesState(games = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = GamesState(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading -> {
                    _state.value = GamesState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)

    }

    fun getImageDominantSwatch(drawable: Drawable, onGenerated: (Palette.Swatch) -> Unit) {
        val bitmap = (drawable as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true)
        Palette.from(bitmap).generate { palette ->
            palette?.dominantSwatch?.let {
                onGenerated(it)
            }
        }
    }

}