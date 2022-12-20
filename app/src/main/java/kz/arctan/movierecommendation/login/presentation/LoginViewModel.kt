package kz.arctan.movierecommendation.login.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kz.arctan.movierecommendation.auth.data.entity.LoginDto
import kz.arctan.movierecommendation.auth.domain.AuthRepository
import kz.arctan.movierecommendation.auth.domain.UserRepository
import kz.arctan.movierecommendation.common.data.LetsSeeResult
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val authRepository: AuthRepository,
) : ViewModel() {
    private val _loginState = MutableStateFlow(LoginState())
    val loginState = _loginState.asStateFlow()

    fun reduce(loginEvent: LoginEvent) {
        viewModelScope.launch {
            when (loginEvent) {
                is LoginEvent.LoginChangeLoginEvent -> _loginState.update { it.copy(email = loginEvent.newLogin) }
                is LoginEvent.PasswordChangeLoginEvent -> _loginState.update { it.copy(password = loginEvent.newPassword) }
                LoginEvent.ShowPasswordLoginEvent -> _loginState.update { it.copy(passwordVisible = !_loginState.value.passwordVisible) }
                LoginEvent.LoginClickLoginEvent -> {
                    _loginState.update { it.copy(isLoading = true, errorMessage = null) }
                    val loginDto = LoginDto(_loginState.value.email, _loginState.value.password)
                    authRepository.login(loginDto)
                        .onSuccess {
                            _loginState.update {
                                it.copy(
                                    isLoggedIn = true,
                                    isLoading = false,
                                    errorMessage = null
                                )
                            }
                        }.onFailure { error ->
                            _loginState.update {
                                it.copy(
                                    isLoggedIn = false,
                                    isLoading = false,
                                    errorMessage = error.localizedMessage
                                )
                            }
                        }
                }
            }
        }
    }

    init {
        viewModelScope.launch {
            val user = userRepository.getUser()
            user.onSuccess {
                _loginState.update {
                    it.copy(
                        isLoggedIn = true,
                        isLoading = false,
                        errorMessage = null
                    )
                }
            }.onFailure {
                _loginState.update {
                    it.copy(
                        isLoggedIn = false,
                        isLoading = false,
                        errorMessage = null
                    )
                }
            }
        }
    }
}