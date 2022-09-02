package com.example.gamesapp.presentation.games_details

import com.example.gamesapp.domain.models.GamesDetails

data class GamesDetailState(
    val isLoading:Boolean = false,
    val games:GamesDetails? = null,
    val error:String = ""

)
