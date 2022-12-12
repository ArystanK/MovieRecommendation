package kz.arctan.movierecommendation.login.data.entity

data class RegisterDto(
    val username: String,
    val password: String,
    val email: String,
    val firstname: String,
    val lastname: String
)
