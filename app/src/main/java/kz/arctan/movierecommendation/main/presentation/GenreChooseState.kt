package kz.arctan.movierecommendation.main.presentation

data class GenreChooseState(
    val genres: List<String> = emptyList(),
    val selectedGenres: List<String> = emptyList(),
)
