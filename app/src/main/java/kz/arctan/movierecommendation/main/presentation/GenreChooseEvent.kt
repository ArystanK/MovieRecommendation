package kz.arctan.movierecommendation.main.presentation

sealed interface GenreChooseEvent {
    @JvmInline
    value class GenrePickedGenreChooseEvent(val genre: String) : GenreChooseEvent

    object SubmitSelectedGenreChooseEvent : GenreChooseEvent
}