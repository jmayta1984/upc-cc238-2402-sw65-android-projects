package pe.edu.upc.appturismo.data.remote

import com.google.gson.annotations.SerializedName
import pe.edu.upc.appturismo.domain.TourPackage

data class PackageDto(
    @SerializedName("descripcion")
    val description: String,
    @SerializedName("estrellas")
    val stars: String,
    @SerializedName("idProducto")
    val id: String,
    @SerializedName("imagen")
    val image: String,
    @SerializedName("nombre")
    val name: String,
    @SerializedName("ubicacin")
    val location: String
)

fun PackageDto.toPackage() = TourPackage(id, name, description, image, location)