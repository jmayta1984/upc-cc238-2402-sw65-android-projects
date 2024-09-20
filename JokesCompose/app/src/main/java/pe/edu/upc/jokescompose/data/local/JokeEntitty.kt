package pe.edu.upc.jokescompose.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jokes")
data class JokeEntity(
    @PrimaryKey
    val id: String,
    val description: String,
    val score: Int
)
