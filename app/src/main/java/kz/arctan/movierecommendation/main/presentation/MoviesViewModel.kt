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
class MoviesViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
) : ViewModel() {
    private val _moviesState = MutableStateFlow(MoviesState())
    val moviesState = _moviesState.asStateFlow()

    fun reduce() {

    }

    init {
        viewModelScope.launch {
            movieRepository.getMoviesByPage(1).onSuccess { movies ->
                _moviesState.update { it.copy(movies = movies) }
            }
        }
    }
}