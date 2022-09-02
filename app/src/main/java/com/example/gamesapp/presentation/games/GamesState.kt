package com.example.gamesapp.presentation.games

import com.example.gamesapp.domain.models.Games

data class GamesState(
    val isLoading:Boolean = false,
    val games:List<Games> = emptyList(),
    val error :String = ""
)