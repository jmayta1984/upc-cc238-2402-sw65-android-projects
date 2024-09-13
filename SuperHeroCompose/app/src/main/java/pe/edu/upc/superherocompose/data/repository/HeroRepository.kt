package pe.edu.upc.superherocompose.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.upc.superherocompose.common.Resource
import pe.edu.upc.superherocompose.data.remote.HeroService
import pe.edu.upc.superherocompose.data.remote.dto.HeroDto
import pe.edu.upc.superherocompose.data.remote.dto.toHero
import pe.edu.upc.superherocompose.domain.model.Hero

class HeroRepository(private val service: HeroService) {

    suspend fun searchHero(name: String): Resource<List<Hero>> = withContext(Dispatchers.IO) {
        val response = service.searchHero(name)
        if (response.isSuccessful) {
            response.body()?.heroes?.let { heroesDto: List<HeroDto> ->
                val heroes = heroesDto.map { heroDto: HeroDto ->
                    heroDto.toHero()
                }.toList()
                return@withContext Resource.Success(data = heroes)
            }
            return@withContext Resource.Error(
                message = response.body()?.error ?: "An error occurred"
            )
        }
        return@withContext Resource.Error(message = response.body()?.error ?: "An error occurred")

    }
}