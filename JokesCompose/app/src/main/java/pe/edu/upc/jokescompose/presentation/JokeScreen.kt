package pe.edu.upc.jokescompose.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun JokeScreen(viewModel: JokeViewModel) {
    val state = viewModel.state.value
    Scaffold { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            OutlinedButton(onClick = {
                viewModel.getRandomJoke()
            }) {
                Text("Get random joke!")
            }
            if (state.isLoading) {
                CircularProgressIndicator()
            }
            if (state.message.isNotEmpty()) {
                Text(state.message)
            }
            state.data?.let { joke ->
                Text(joke.description)
            }
        }
    }
}