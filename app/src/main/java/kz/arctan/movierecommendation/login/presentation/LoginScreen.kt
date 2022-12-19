package kz.arctan.movierecommendation.login.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kz.arctan.movierecommendation.Routes
import kz.arctan.movierecommendation.common.presentation.LetsSeeButton
import kz.arctan.movierecommendation.common.presentation.LetsSeePasswordTextField
import kz.arctan.movierecommendation.common.presentation.LetsSeeTextField
import kz.arctan.movierecommendation.common.presentation.LetsSeeTitle
import kz.arctan.movierecommendation.ui.theme.MovieRecommendationTheme

@Composable
fun LoginView(
    viewModel: LoginViewModel,
    navController: NavController,
) {
    val state by viewModel.loginState.collectAsState()
    LoginScreen(
        email = state.login,
        password = state.password,
        passwordVisible = state.passwordVisible,
        showPassword = { viewModel.reduce(LoginEvent.ShowPasswordLoginEvent) },
        onEmailChange = { viewModel.reduce(LoginEvent.LoginChangeLoginEvent(it)) },
        onPasswordChange = { viewModel.reduce(LoginEvent.PasswordChangeLoginEvent(it)) },
        goToRegistration = { navController.navigate(Routes.RegistrationView) },
        login = { navController.navigate(Routes.ChooseGenreView) },
    )
}

@Composable
fun LoginScreen(
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    passwordVisible: Boolean,
    showPassword: () -> Unit,
    goToRegistration: () -> Unit,
    login: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(horizontal = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LetsSeeTitle(title = "Welcome", subtitle = "Login to your account")
        }
        Column(
            modifier = Modifier.padding(top = 36.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(text = "Email", fontWeight = FontWeight.SemiBold)
            LetsSeeTextField(
                value = email,
                onValueChange = onEmailChange,
                placeholder = "Email",
            )
            Text(text = "Password", fontWeight = FontWeight.SemiBold)
            LetsSeePasswordTextField(
                password = password,
                onPasswordChange = onPasswordChange,
                showPassword = showPassword,
                passwordVisible = passwordVisible
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(top = 64.dp)
                .padding(horizontal = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            LetsSeeButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                text = "Login",
                onClick = login,
            )
            Row {
                Text(text = "Don't have an account?")
                Box(modifier = Modifier.width(4.dp))
                Text(
                    text = "Create now",
                    color = Color.Blue,
                    modifier = Modifier.clickable(onClick = goToRegistration)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    MovieRecommendationTheme {
        LoginScreen(
            login = {},
            email = "",
            password = "",
            onEmailChange = {},
            onPasswordChange = {},
            goToRegistration = {},
            passwordVisible = false,
            showPassword = {}
        )
    }
}