package pe.edu.upc.superherocompose.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Appearance(
    @SerializedName("eye-color")
    val eyeColor: String,
    val gender: String,
    @SerializedName("hair-color")
    val hairColor: String,
    val height: List<String>,
    val race: String,
    val weight: List<String>
)