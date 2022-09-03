package com.example.gamesapp.domain.repository

import com.example.gamesapp.data.dto.GamesDetailsDto
import com.example.gamesapp.data.dto.GamesResponseDto
import com.example.gamesapp.data.dto.developers.DeveloperResponseDto

interface GamesRepository {
    suspend fun getGames():GamesResponseDto

    suspend fun getGamesDetails(id:String):GamesDetailsDto

    suspend fun getDeveloper():DeveloperResponseDto
}