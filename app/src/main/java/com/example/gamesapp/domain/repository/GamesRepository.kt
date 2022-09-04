package com.example.gamesapp.domain.repository

import com.example.gamesapp.data.dto.GamesDetailsDto
import com.example.gamesapp.data.dto.GamesResponseDto
import com.example.gamesapp.data.dto.developers.DeveloperResponseDto
import com.example.gamesapp.data.dto.genres.GenresResponseDto

interface GamesRepository {
    suspend fun getGames():GamesResponseDto

    suspend fun getGamesDetails(id:String):GamesDetailsDto

    suspend fun getDeveloper():DeveloperResponseDto

    suspend fun getGenres():GenresResponseDto
}