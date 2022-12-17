package kz.arctan.movierecommendation.register.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor() : ViewModel() {
    private val _registrationState = MutableStateFlow(RegistrationState())
    val registrationState = _registrationState.asStateFlow()

    fun reduce(registrationEvent: RegistrationEvent) {
        when (registrationEvent) {
            is RegistrationEvent.EmailChangeRegistrationEvent ->
                _registrationState.update { it.copy(email = registrationEvent.email) }
            is RegistrationEvent.PasswordChangeRegistrationEvent ->
                _registrationState.update { it.copy(password = registrationEvent.password) }
            is RegistrationEvent.PasswordVisibilityToggleRegistrationEvent ->
                _registrationState.update { it.copy(passwordShown = !_registrationState.value.passwordShown) }
            RegistrationEvent.RegisterClickRegistrationEvent -> {

            }
            is RegistrationEvent.UsernameChangeRegistrationEvent ->
                _registrationState.update { it.copy(username = registrationEvent.username) }
        }
    }
}