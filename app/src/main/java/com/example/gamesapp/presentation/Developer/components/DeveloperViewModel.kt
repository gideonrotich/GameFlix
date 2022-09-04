package com.example.gamesapp.presentation.Developer.components

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.palette.graphics.Palette
import com.example.gamesapp.domain.use_cases.GetDevelopersUseCase
import com.example.gamesapp.presentation.Developer.DeveloperState
import com.example.gamesapp.presentation.games.GamesState
import com.example.gamesapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DeveloperViewModel @Inject constructor(
    private val getDevelopersUseCase: GetDevelopersUseCase
): ViewModel(){
    private val _state = mutableStateOf(DeveloperState())
    val state:State<DeveloperState> = _state


    init {
        getDeveloper()
    }

    private fun getDeveloper(){
        getDevelopersUseCase().onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = DeveloperState(developers = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = DeveloperState(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading -> {
                    _state.value = DeveloperState(isLoading = true)
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