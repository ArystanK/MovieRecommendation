package kz.arctan.movierecommendation.register.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kz.arctan.movierecommendation.auth.data.entity.RegisterDto
import kz.arctan.movierecommendation.auth.domain.AuthRepository
import kz.arctan.movierecommendation.common.data.LetsSeeResult
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val authRepository: AuthRepository,
) : ViewModel() {
    private val _registrationState = MutableStateFlow(RegistrationState())
    val registrationState = _registrationState.asStateFlow()

    private val _userRegistered = Channel<LetsSeeResult<Boolean>>()
    val userRegistered = _userRegistered.receiveAsFlow()

    fun reduce(registrationEvent: RegistrationEvent) {
        viewModelScope.launch {
            when (registrationEvent) {
                is RegistrationEvent.EmailChangeRegistrationEvent ->
                    _registrationState.update { it.copy(email = registrationEvent.email) }
                is RegistrationEvent.PasswordChangeRegistrationEvent ->
                    _registrationState.update { it.copy(password = registrationEvent.password) }
                is RegistrationEvent.PasswordVisibilityToggleRegistrationEvent ->
                    _registrationState.update { it.copy(passwordShown = !_registrationState.value.passwordShown) }
                RegistrationEvent.RegisterClickRegistrationEvent -> {
                    _userRegistered.send(LetsSeeResult.Loading())
                    val registerDto = RegisterDto(
                        _registrationState.value.username,
                        _registrationState.value.password,
                        _registrationState.value.email,
                    )
                    authRepository.register(registerDto)
                        .onFailure {
                            _userRegistered.send(LetsSeeResult.Error(it.localizedMessage
                                ?: "Unknown error"))
                        }.onSuccess {
                            _userRegistered.send(LetsSeeResult.Success(true))
                        }
                }
                is RegistrationEvent.UsernameChangeRegistrationEvent ->
                    _registrationState.update { it.copy(username = registrationEvent.username) }
            }
        }
    }
}