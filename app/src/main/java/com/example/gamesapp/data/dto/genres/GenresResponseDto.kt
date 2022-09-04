package com.example.gamesapp.data.dto.genres

data class GenresResponseDto(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<Result>
)