package com.example.gamesapp.data.mapper

import com.example.gamesapp.data.dto.GamesDetailsDto
import com.example.gamesapp.data.dto.Result
import com.example.gamesapp.domain.models.Developer
import com.example.gamesapp.domain.models.Games
import com.example.gamesapp.domain.models.GamesDetails
import com.example.gamesapp.domain.models.Genres

fun Result.toGames():Games{
    return Games(
        added, added_by_status, background_image, clip, dominant_color, esrb_rating, genres, id, metacritic, name, parent_platforms, platforms, playtime, rating, rating_top, ratings, ratings_count, released, reviews_count, reviews_text_count, saturated_color, short_screenshots, slug, stores, suggestions_count, tags, tba, updated, user_game
    )
}


fun GamesDetailsDto.toGamesDetails():GamesDetails{
    return GamesDetails(
        achievements_count, added, added_by_status, additions_count, alternative_names, background_image, background_image_additional, creators_count, description, esrb_rating, game_series_count, id, metacritic, metacritic_platforms, metacritic_url, movies_count, name, name_original, parent_achievements_count, parents_count, platforms, playtime, rating, rating_top, ratings, ratings_count, reactions, reddit_count, reddit_description, reddit_logo, reddit_name, reddit_url, released, reviews_text_count, screenshots_count, slug, suggestions_count, tba, twitch_count, updated, website, youtube_count
    )
}

fun com.example.gamesapp.data.dto.developers.Result.toDeveloper():Developer{
    return Developer(
         games_count, id, image_background, name, slug
    )
}

fun com.example.gamesapp.data.dto.genres.Result.toGenres(): Genres {
    return Genres(
        games_count, id, image_background, name, slug
    )
}