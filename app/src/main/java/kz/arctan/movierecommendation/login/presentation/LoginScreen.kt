package kz.arctan.movierecommendation.login.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LoginView(
    viewModel: LoginViewModel = viewModel()
) {
    val state = viewModel.loginState.collectAsState()
    LoginScreen(
        email = state.value.login,
        password = state.value.password,
        onEmailChange = { viewModel.reduce(LoginEvent.LoginChangeLoginEvent(it)) },
        onPasswordChange = { viewModel.reduce(LoginEvent.PasswordChangeLoginEvent(it)) }
    )
}

@Composable
fun LoginScreen(
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome",
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 2.sp
            )
            Text(
                text = "Login to your account",
                style = MaterialTheme.typography.caption,
                color = Color.Gray
            )
        }
        Column(
            modifier = Modifier.padding(top = 36.dp)
        ) {
            Text(text = "Email")
            TextField(
                value = "",
                onValueChange = {},
                placeholder = { Text(text = "Email") }
            )
            Text(text = "Password")
            TextField(
                value = "",
                onValueChange = {},
                placeholder = { Text(text = "Password") },
                trailingIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Visibility,
                            contentDescription = "Visibility toggle"
                        )
                    }
                }
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Login")
            }
            Row {
                Text(text = "Don't have an account?")
                Text(text = "Create now")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        email = "",
        password = "",
        onEmailChange = {},
        onPasswordChange = {}
    )
}