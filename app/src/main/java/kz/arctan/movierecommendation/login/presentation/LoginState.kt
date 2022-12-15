package kz.arctan.movierecommendation.login.presentation

data class LoginState(
    val login: String = "",
    val password: String = "",
    val passwordVisible: Boolean = false
)
