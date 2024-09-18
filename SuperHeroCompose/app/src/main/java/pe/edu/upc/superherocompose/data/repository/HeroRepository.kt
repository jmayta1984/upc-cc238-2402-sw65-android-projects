package pe.edu.upc.superherocompose.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.upc.superherocompose.common.Resource
import pe.edu.upc.superherocompose.data.local.HeroDao
import pe.edu.upc.superherocompose.data.local.HeroEntity
import pe.edu.upc.superherocompose.data.remote.HeroService
import pe.edu.upc.superherocompose.data.remote.dto.HeroDto
import pe.edu.upc.superherocompose.data.remote.dto.toHero
import pe.edu.upc.superherocompose.domain.model.Hero

class HeroRepository(private val service: HeroService, private val dao: HeroDao) {

    suspend fun isFavorite(id: String): Boolean = withContext(Dispatchers.IO){

        dao.fetchById(id)?.let {
            return@withContext true
        }
        return@withContext false
    }


    suspend fun searchHero(name: String): Resource<List<Hero>> = withContext(Dispatchers.IO) {
        val response = service.searchHero(name)
        if (response.isSuccessful) {
            response.body()?.heroes?.let { heroesDto: List<HeroDto> ->
                val heroes = mutableListOf<Hero>()
                heroesDto.forEach { heroDto: HeroDto ->
                    val hero = heroDto.toHero()
                    hero.isFavorite = isFavorite(hero.id)
                    heroes.add(hero)
                }
                return@withContext Resource.Success(data = heroes)
            }
            return@withContext Resource.Error(
                message = response.body()?.error ?: "An error occurred"
            )
        }
        return@withContext Resource.Error(message = response.body()?.error ?: "An error occurred")

    }

    suspend fun insertHero(hero: Hero) = withContext(Dispatchers.IO) {
        dao.insert(HeroEntity(hero.id, hero.name, hero.fullName, hero.url))
    }

    suspend fun deleteHero(hero: Hero) = withContext(Dispatchers.IO) {
        dao.delete(HeroEntity(hero.id, hero.name, hero.fullName, hero.url))
    }
}