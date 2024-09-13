package pe.edu.upc.superherocompose.presentation.hero_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pe.edu.upc.superherocompose.common.Resource
import pe.edu.upc.superherocompose.common.UIState
import pe.edu.upc.superherocompose.data.repository.HeroRepository
import pe.edu.upc.superherocompose.domain.model.Hero

class HeroListViewModel(private val repository: HeroRepository) : ViewModel() {

    private val _name = mutableStateOf("")
    val name: State<String> get() = _name

    private val _state = mutableStateOf(UIState<List<Hero>>())
    val state: State<UIState<List<Hero>>> get() = _state

    fun onNameChanged(name: String) {
        _name.value = name
    }

    fun searchHero() {
        _state.value = UIState(isLoading = true)
        viewModelScope.launch {
            val result = repository.searchHero(_name.value)

            if (result is Resource.Success) {
              _state.value = UIState(data = result.data)
            } else {
                _state.value = UIState(message = result.message?:"An error occurred")
            }
        }
    }
}