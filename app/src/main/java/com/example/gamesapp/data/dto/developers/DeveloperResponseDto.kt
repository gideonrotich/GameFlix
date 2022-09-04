package com.example.gamesapp.data.dto.developers

data class DeveloperResponseDto(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<Result>
)