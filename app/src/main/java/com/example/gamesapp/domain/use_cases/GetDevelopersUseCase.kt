package com.example.gamesapp.domain.use_cases

import com.example.gamesapp.data.api.GamesApi
import com.example.gamesapp.data.mapper.toDeveloper
import com.example.gamesapp.data.mapper.toGames
import com.example.gamesapp.domain.models.Developer
import com.example.gamesapp.domain.models.Games
import com.example.gamesapp.domain.repository.GamesRepository
import com.example.gamesapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetDevelopersUseCase @Inject constructor(
    private val repository:GamesRepository
){
    operator fun invoke(): Flow<Resource<List<Developer>>> = flow{
        try {
            emit(Resource.Loading())
            val data = repository.getDeveloper().results.map { it.toDeveloper() }
            emit(Resource.Success(data))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "Error"))
        }catch (e: IOException){
            emit(Resource.Error(e.localizedMessage ?: "one error"))
        }
    }

}