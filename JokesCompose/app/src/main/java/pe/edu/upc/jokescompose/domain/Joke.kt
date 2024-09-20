package pe.edu.upc.jokescompose.domain

data class Joke(
    val id: String,
    val description: String,
    var score: Int = 0
)