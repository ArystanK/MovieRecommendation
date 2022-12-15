package kz.arctan.movierecommendation.login.presentation

sealed interface LoginEvent {
    @JvmInline
    value class LoginChangeLoginEvent(val newLogin: String) : LoginEvent

    @JvmInline
    value class PasswordChangeLoginEvent(val newPassword: String) : LoginEvent

    object ShowPasswordLoginEvent : LoginEvent
}