package kz.arctan.movierecommendation.main.data.entity

data class Movie(
    val title: String,
    val description: String,
    val genres: List<String>,
    val image: String,
)
