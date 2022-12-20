package kz.arctan.movierecommendation.main.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kz.arctan.movierecommendation.main.domain.MovieRepository
import javax.inject.Inject

@HiltViewModel
class ChooseGenreViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
) : ViewModel() {
    private val _genreChooseState = MutableStateFlow(GenreChooseState())
    val mainState = _genreChooseState.asStateFlow()

    init {
        viewModelScope.launch {
            movieRepository.getAllGenres().onSuccess { genres ->
                _genreChooseState.update {
                    it.copy(genres = genres)
                }
            }
        }
    }

    fun reduce(genreChooseEvent: GenreChooseEvent) {
        when (genreChooseEvent) {
            is GenreChooseEvent.GenrePickedGenreChooseEvent -> _genreChooseState.update {
                it.copy(selectedGenres = if (genreChooseEvent.genre in _genreChooseState.value.selectedGenres)
                    _genreChooseState.value.selectedGenres - genreChooseEvent.genre
                else
                    _genreChooseState.value.selectedGenres + genreChooseEvent.genre
                )
            }
            GenreChooseEvent.SubmitSelectedGenreChooseEvent -> {

            }
        }
    }
}