package com.example.gamesapp.presentation.Developer

import com.example.gamesapp.domain.models.Developer
import com.example.gamesapp.domain.models.Games

data class DeveloperState(
    val isLoading:Boolean = false,
    val developers:List<Developer> = emptyList(),
    val error :String = ""
)
