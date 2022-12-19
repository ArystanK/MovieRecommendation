package kz.arctan.movierecommendation.main.presentation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun MainScreen(navController: NavController) {
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navigationBackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navigationBackEntry?.destination

            }
        },
    ) {

    }
}