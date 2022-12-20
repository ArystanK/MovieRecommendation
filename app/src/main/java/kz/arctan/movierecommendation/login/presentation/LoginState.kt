package kz.arctan.movierecommendation.login.presentation

data class LoginState(
    val email: String = "",
    val password: String = "",
    val passwordVisible: Boolean = false
)
