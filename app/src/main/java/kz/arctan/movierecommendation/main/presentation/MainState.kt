package kz.arctan.movierecommendation.main.presentation

data class MainState(
    val genres: List<String> = listOf(
        "Action",
        "Adventure",
        "Animation",
        "Children",
        "Comedy",
        "Crime",
        "Documentary",
        "Drama",
        "Fantasy",
        "Film-Noir",
        "Horror",
        "IMAX",
        "Musical",
        "Mystery",
        "Romance",
        "Sci-Fi",
        "Thriller",
        "War",
        "Western",
        "(no genres listed)",
    ),
    val selectedGenres: List<String> = emptyList(),
)
