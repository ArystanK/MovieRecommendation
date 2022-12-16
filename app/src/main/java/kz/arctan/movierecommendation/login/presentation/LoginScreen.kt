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
import kz.arctan.movierecommendation.common.presentation.LetsSeeTextField
import kz.arctan.movierecommendation.ui.theme.MovieRecommendationTheme

@Composable
fun LoginView(
    viewModel: LoginViewModel,
    navController: NavController
) {
    val state = viewModel.loginState.collectAsState()
    LoginScreen(
        email = state.value.login,
        password = state.value.password,
        passwordVisible = state.value.passwordVisible,
        showPassword = { viewModel.reduce(LoginEvent.ShowPasswordLoginEvent) },
        onEmailChange = { viewModel.reduce(LoginEvent.LoginChangeLoginEvent(it)) },
        onPasswordChange = { viewModel.reduce(LoginEvent.PasswordChangeLoginEvent(it)) },
        goToRegistration = { navController.navigate(Routes.RegistrationView) },
        login = {},
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
    login: () -> Unit
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
            Text(
                text = "Welcome",
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 2.sp,
                fontSize = 32.sp
            )
            Text(
                text = "Login to your account",
                style = MaterialTheme.typography.caption,
                color = Color.Gray.copy(alpha = 0.5f),
                fontSize = 22.sp,
            )
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
            LetsSeeTextField(
                value = password,
                onValueChange = onPasswordChange,
                placeholder = "Password",
                trailingIcon = {
                    IconButton(onClick = showPassword) {
                        Icon(
                            imageVector = if (!passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = "Visibility toggle"
                        )
                    }
                },
                isVisible = passwordVisible
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