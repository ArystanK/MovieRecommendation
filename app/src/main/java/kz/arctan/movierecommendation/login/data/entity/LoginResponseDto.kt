package kz.arctan.movierecommendation.login.data.entity

data class LoginResponseDto(
    val jwt: String,
    val user: User
)
