package com.example.gamesapp.domain.use_cases

import com.example.gamesapp.data.mapper.toGames
import com.example.gamesapp.domain.models.Games
import com.example.gamesapp.domain.repository.GamesRepository
import com.example.gamesapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetGamesUseCase @Inject constructor(
    private val repository: GamesRepository
) {
    operator fun invoke():Flow<Resource<List<Games>>> = flow{
        try {
            emit(Resource.Loading())
            val data = repository.getGames().results.map { it.toGames() }
            emit(Resource.Success(data))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "Error"))
        }catch (e: IOException){
            emit(Resource.Error(e.localizedMessage ?: "one error"))
        }
    }
}