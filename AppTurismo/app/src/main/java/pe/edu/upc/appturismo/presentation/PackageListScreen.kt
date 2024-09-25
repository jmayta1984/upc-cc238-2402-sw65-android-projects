package pe.edu.upc.appturismo.presentation

import androidx.compose.runtime.Composable

@Composable
fun PackageListScreen(viewModel: PackageListViewModel) {

}

data class Place (
    val id: String,
    val description: String
)


data class Type (
    val id: String,
    val description: String
)

