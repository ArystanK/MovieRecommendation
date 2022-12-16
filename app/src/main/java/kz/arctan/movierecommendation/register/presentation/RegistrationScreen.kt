package kz.arctan.movierecommendation.register.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun RegistrationView(viewModel: RegistrationViewModel, navController: NavController) {
    RegistrationScreen()
}

@Composable
fun RegistrationScreen(

) {
    var username by remember { mutableStateOf("") }
    Column {
        TextField(
            value = username,
            onValueChange = { username = it }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RegistrationScreenPreview() {
    RegistrationScreen()
}