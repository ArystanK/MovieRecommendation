package kz.arctan.movierecommendation.register.presentation

sealed interface RegistrationEvent {
    @JvmInline
    value class UsernameChangeRegistrationEvent(val username: String) : RegistrationEvent

    @JvmInline
    value class EmailChangeRegistrationEvent(val email: String) : RegistrationEvent

    @JvmInline
    value class PasswordChangeRegistrationEvent(val password: String) : RegistrationEvent

    object PasswordVisibilityToggleRegistrationEvent : RegistrationEvent

    object RegisterClickRegistrationEvent : RegistrationEvent
}