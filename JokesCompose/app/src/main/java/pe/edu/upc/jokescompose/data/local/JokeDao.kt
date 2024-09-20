package pe.edu.upc.jokescompose.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface JokeDao {

    @Insert
    suspend fun insert(jokeEntity: JokeEntity)

    @Delete
    suspend fun delete(jokeEntity: JokeEntity)

    @Update
    suspend fun update(jokeEntity: JokeEntity)

    @Query("select * from jokes")
    suspend fun fetchAll(): List<JokeEntity>

    @Query("select * from jokes where id =:id")
    suspend fun fetchById(id: String): JokeEntity?

}