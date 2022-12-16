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
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import kz.arctan.movierecommendation.login.presentation.LoginView
import kz.arctan.movierecommendation.login.presentation.LoginViewModel
import kz.arctan.movierecommendation.register.presentation.RegistrationScreen
import kz.arctan.movierecommendation.register.presentation.RegistrationView
import kz.arctan.movierecommendation.register.presentation.RegistrationViewModel
import kz.arctan.movierecommendation.ui.theme.MovieRecommendationTheme

@AndroidEntryPoint
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
            NavHost(navController = navController, startDestination = Routes.LoginView) {
                composable(Routes.LoginView) {
                    val loginViewModel = hiltViewModel<LoginViewModel>()
                    LoginView(viewModel = loginViewModel, navController = navController)
                }
                composable(Routes.RegistrationView) {
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