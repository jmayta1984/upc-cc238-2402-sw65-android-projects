package pe.edu.upc.jokescompose.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pe.edu.upc.jokescompose.common.Resource
import pe.edu.upc.jokescompose.common.UIState
import pe.edu.upc.jokescompose.data.JokeRepository
import pe.edu.upc.jokescompose.domain.Joke

class JokeViewModel(private val repository: JokeRepository) : ViewModel() {
    private val _state = mutableStateOf(UIState<Joke>())
    val state: State<UIState<Joke>> get() = _state

    fun getRandomJoke() {
        _state.value = UIState(isLoading = true)
        viewModelScope.launch {
            val result = repository.getRandomJoke()
            if (result is Resource.Success) {
                _state.value = UIState(data = result.data)
            } else {
                _state.value = UIState(message = result.message ?: "An error occurred")
            }

        }
    }

    fun onScoreChanged(score: Int) {
        _state.value.data?.let { joke: Joke ->
            val newJoke = Joke(
                joke.id,
                joke.description,
                if (score == joke.score) 0 else score
            )
            _state.value = UIState(data = newJoke)
        }


    }
}