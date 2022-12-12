package kz.arctan.movierecommendation.login.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
class LoginViewModel : ViewModel() {
    private val _loginState = MutableStateFlow(LoginState())
    val loginState: StateFlow<LoginState> = _loginState.asStateFlow()

    fun reduce(loginEvent: LoginEvent) {
        when (loginEvent) {
            is LoginEvent.LoginChangeLoginEvent -> _loginState.update { it.copy(login = loginEvent.newLogin) }
            is LoginEvent.PasswordChangeLoginEvent -> _loginState.update { it.copy(password = loginEvent.newPassword) }
        }
    }
}