package kz.arctan.movierecommendation.register.presentation

sealed interface RegistrationEvent {
    @JvmInline
    value class UsernameChangeRegistrationEvent(val username: String) : RegistrationEvent

    @JvmInline
    value class EmailChangeRegistrationEvent(val email: String) : RegistrationEvent

    @JvmInline
    value class PasswordChangeRegistrationEvent(val password: String) : RegistrationEvent

    @JvmInline
    value class PasswordVisibilityToggleRegistrationEvent(val passwordShown: Boolean) :
        RegistrationEvent

    object RegisterClickRegistrationEvent : RegistrationEvent
}