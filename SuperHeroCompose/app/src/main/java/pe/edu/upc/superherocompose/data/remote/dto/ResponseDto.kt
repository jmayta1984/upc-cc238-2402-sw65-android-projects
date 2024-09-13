package pe.edu.upc.superherocompose.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ResponseDto(
    val response: String,
    @SerializedName("results")
    val heroes: List<HeroDto>?,
    val error: String?
)