package pe.edu.upc.jokescompose.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.upc.jokescompose.common.Resource
import pe.edu.upc.jokescompose.domain.Joke

class JokeRepository(private val service: JokeService) {

    suspend fun getRandomJoke(): Resource<Joke>  = withContext(Dispatchers.IO){

        try {
            val response = service.getRandomJoke()
            if (response.isSuccessful){
                response.body()?.let { jokeDto: JokeDto ->
                    val joke = jokeDto.toJoke()
                    return@withContext Resource.Success(data = joke)
                }
                return@withContext Resource.Error(response.message())
            }
            return@withContext Resource.Error(response.message())

        } catch (e: Exception){
            return@withContext Resource.Error(e.message?:"An error occurred")

        }
    }
}