package kz.arctan.movierecommendation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kz.arctan.movierecommendation.login.presentation.LoginView
import kz.arctan.movierecommendation.login.presentation.LoginViewModel
import kz.arctan.movierecommendation.register.presentation.RegistrationView
import kz.arctan.movierecommendation.register.presentation.RegistrationViewModel
import kz.arctan.movierecommendation.ui.theme.MovieRecommendationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    MovieRecommendationTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "login") {
                composable("login") {
                    val loginViewModel = hiltViewModel<LoginViewModel>()
                    LoginView(viewModel = loginViewModel, navController = navController)
                }
                composable("registration") {
                    val registrationViewModel = hiltViewModel<RegistrationViewModel>()
                    RegistrationView(
                        viewModel = registrationViewModel,
                        navController = navController
                    )
                }
            }
        }
    }
}