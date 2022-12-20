package kz.arctan.movierecommendation.register.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Snackbar
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
import kz.arctan.movierecommendation.common.data.LetsSeeResult
import kz.arctan.movierecommendation.common.presentation.LetsSeeButton
import kz.arctan.movierecommendation.common.presentation.LetsSeePasswordTextField
import kz.arctan.movierecommendation.common.presentation.LetsSeeTextField
import kz.arctan.movierecommendation.common.presentation.LetsSeeTitle

@Composable
fun RegistrationView(
    viewModel: RegistrationViewModel,
    navController: NavController,
) {
    val state by viewModel.registrationState.collectAsState()
    val isRegistered by viewModel.userRegistered.collectAsState(initial = LetsSeeResult.Init())
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var isLoading by remember { mutableStateOf(false) }
    var isSuccess by remember { mutableStateOf(false) }
    when (isRegistered) {
        is LetsSeeResult.Error -> {
            isLoading = false
            errorMessage = (isRegistered as LetsSeeResult.Error<Boolean>).message
        }
        is LetsSeeResult.Init -> {}
        is LetsSeeResult.Loading -> {
            isLoading = true
            errorMessage = null
            isSuccess = false
        }
        is LetsSeeResult.Success -> {
            isLoading = false
            isSuccess = true
        }
    }
    if (isSuccess) navController.popBackStack()
    RegistrationScreen(
        username = state.username,
        onUsernameChange = { viewModel.reduce(RegistrationEvent.UsernameChangeRegistrationEvent(it)) },
        email = state.email,
        onEmailChange = { viewModel.reduce(RegistrationEvent.EmailChangeRegistrationEvent(it)) },
        password = state.password,
        onPasswordChange = { viewModel.reduce(RegistrationEvent.PasswordChangeRegistrationEvent(it)) },
        showPassword = { viewModel.reduce(RegistrationEvent.PasswordVisibilityToggleRegistrationEvent) },
        passwordVisible = state.passwordShown,
        register = { viewModel.reduce(RegistrationEvent.RegisterClickRegistrationEvent) }
    )
    if (isLoading) Box(Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) { CircularProgressIndicator() }
    errorMessage?.let {
        Snackbar {
            Text(text = it)
        }
    }
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
    register: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(48.dp),
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