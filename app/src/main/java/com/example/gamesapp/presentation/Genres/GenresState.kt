package com.example.gamesapp.presentation.Genres

import com.example.gamesapp.domain.models.Genres

data class GenresState(
    val isLoading:Boolean = false,
    val genres:List<Genres> = emptyList(),
    val error:String= ""
)
