package com.example.gamesapp.data.api

import com.example.gamesapp.BuildConfig.API_KEY
import com.example.gamesapp.data.dto.GamesDetailsDto
import com.example.gamesapp.data.dto.GamesResponseDto
import com.example.gamesapp.data.dto.developers.DeveloperResponseDto
import com.example.gamesapp.data.dto.genres.GenresResponseDto
import com.example.gamesapp.util.Constants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GamesApi {
    @GET("games")
    suspend fun getGames():GamesResponseDto

    @GET("games/{id}")
    suspend fun getGamesDetails(@Path("id")id:String):GamesDetailsDto

    @GET("developers")
    suspend fun getDevelopers():DeveloperResponseDto

    @GET("genres")
    suspend fun getGenres():GenresResponseDto
}