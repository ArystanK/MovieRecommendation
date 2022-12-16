package kz.arctan.movierecommendation.auth.data.entity

data class LoginResponseDto(
    val jwt: String,
    val user: User
)
