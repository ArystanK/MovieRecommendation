package kz.arctan.movierecommendation.main.presentation

sealed interface MainEvent {
    @JvmInline
    value class GenrePickedMainEvent(val genre: String) : MainEvent
}