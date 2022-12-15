package kz.arctan.movierecommendation.register.presentation

data class RegistrationState(
    val username: String,
    val email: String,
    val password: String,
    val passwordShown: Boolean
)
