package kz.arctan.movierecommendation.auth.data.entity

data class RegisterDto(
    val username: String,
    val password: String,
    val email: String,
)
