package com.fcy.calculator_x.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fcy.calculator_x.MainViewModel
import com.fcy.calculator_x.ui.main.MainScreen
import com.fcy.calculator_x.ui.splash.Splash

@Composable
fun CalculatorNavigation(
    navigator: NavHostController,
    viewModel: MainViewModel
) {
    val screens = remember(navigator) {
        Screens(navigator)
    }
    NavHost(navController = navigator, startDestination = Screens.ROUTE_SPLASH) {
        composable(route = Screens.ROUTE_SPLASH) {
            Splash(navigateAction = screens.navigateToMainScreen)
        }
        composable(route = Screens.ROUTE_MAIN) {
            MainScreen(viewModel)
        }
    }
}