package kz.arctan.movierecommendation.register.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kz.arctan.movierecommendation.common.presentation.LetsSeeButton
import kz.arctan.movierecommendation.common.presentation.LetsSeePasswordTextField
import kz.arctan.movierecommendation.common.presentation.LetsSeeTextField
import kz.arctan.movierecommendation.common.presentation.LetsSeeTitle

@Composable
fun RegistrationView(
    viewModel: RegistrationViewModel,
    navController: NavController
) {
    val state = viewModel.registrationState.collectAsState()
    RegistrationScreen(
        username = state.value.username,
        onUsernameChange = { viewModel.reduce(RegistrationEvent.UsernameChangeRegistrationEvent(it)) },
        email = state.value.email,
        onEmailChange = { viewModel.reduce(RegistrationEvent.EmailChangeRegistrationEvent(it)) },
        password = state.value.password,
        onPasswordChange = { viewModel.reduce(RegistrationEvent.PasswordChangeRegistrationEvent(it)) },
        showPassword = { viewModel.reduce(RegistrationEvent.PasswordVisibilityToggleRegistrationEvent) },
        passwordVisible = state.value.passwordShown,
        register = {}
    )
}

@Composable
fun RegistrationScreen(
    username: String,
    onUsernameChange: (String) -> Unit,
    email: String,
    onEmailChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    showPassword: () -> Unit,
    passwordVisible: Boolean,
    register: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(48.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            LetsSeeTitle(title = "Register", subtitle = "Create a new account")
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(text = "Username", fontWeight = FontWeight.SemiBold)
                LetsSeeTextField(
                    value = username,
                    onValueChange = onUsernameChange,
                    placeholder = "Username"
                )
                Text(text = "Email", fontWeight = FontWeight.SemiBold)
                LetsSeeTextField(
                    value = email,
                    onValueChange = onEmailChange,
                    placeholder = "Email"
                )
                Text(text = "Password", fontWeight = FontWeight.SemiBold)
                LetsSeePasswordTextField(
                    password = password,
                    onPasswordChange = onPasswordChange,
                    showPassword = showPassword,
                    passwordVisible = passwordVisible
                )
            }
        }
        LetsSeeButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            text = "Register",
            onClick = register,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RegistrationScreenPreview() {
    RegistrationScreen(
        username = "",
        onUsernameChange = {},
        email = "",
        onEmailChange = {},
        password = "",
        onPasswordChange = {},
        showPassword = { /*TODO*/ },
        passwordVisible = false,
        register = {}
    )
}