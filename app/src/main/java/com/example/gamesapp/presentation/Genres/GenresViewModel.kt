package com.example.gamesapp.presentation.Genres

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.palette.graphics.Palette
import com.example.gamesapp.domain.use_cases.GetGenresUseCase
import com.example.gamesapp.presentation.Developer.DeveloperState
import com.example.gamesapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class GenresViewModel @Inject constructor(
    private val getGenresUseCase: GetGenresUseCase
) : ViewModel() {

    private val _state = mutableStateOf(GenresState())
    val state: State<GenresState> = _state


    init {
        getGenres()
    }

    private fun getGenres() {
        getGenresUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = GenresState(genres = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value =
                        GenresState(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading -> {
                    _state.value = GenresState(isLoading = true)
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