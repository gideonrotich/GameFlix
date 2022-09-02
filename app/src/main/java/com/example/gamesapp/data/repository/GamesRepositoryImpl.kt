package com.example.gamesapp.data.repository

import com.example.gamesapp.data.api.GamesApi
import com.example.gamesapp.data.dto.GamesDetailsDto
import com.example.gamesapp.data.dto.GamesResponseDto
import com.example.gamesapp.domain.repository.GamesRepository
import javax.inject.Inject

class GamesRepositoryImpl @Inject constructor(
    private val api:GamesApi
): GamesRepository {
    override suspend fun getGames(): GamesResponseDto {
        return api.getGames()
    }

    override suspend fun getGamesDetails(id: String): GamesDetailsDto {
        return api.getGamesDetails(id)
    }
}