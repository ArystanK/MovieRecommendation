package kz.arctan.movierecommendation.main.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    private val _mainState = MutableStateFlow(MainState())
    val mainState = _mainState.asStateFlow()

    fun reduce(mainEvent: MainEvent) {
        when (mainEvent) {
            is MainEvent.GenrePickedMainEvent -> _mainState.update {
                it.copy(selectedGenres = if (mainEvent.genre in _mainState.value.selectedGenres)
                    _mainState.value.selectedGenres - mainEvent.genre
                else
                    _mainState.value.selectedGenres + mainEvent.genre
                )
            }
        }
    }
}