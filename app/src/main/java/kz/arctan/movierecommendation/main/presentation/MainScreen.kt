package kz.arctan.movierecommendation.main.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
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
        Box(modifier = Modifier.padding(it)) {

        }
    }
}