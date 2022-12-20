package kz.arctan.movierecommendation.main.presentation

import kz.arctan.movierecommendation.main.data.entity.MovieDto

data class MoviesState(
    val movies: List<MovieDto> = emptyList(),
)
