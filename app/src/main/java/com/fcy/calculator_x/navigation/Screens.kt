package com.fcy.calculator_x.navigation

import androidx.navigation.NavHostController

class Screens(
    private val navController: NavHostController
) {
    companion object {
        const val ROUTE_MAIN = "main"
        const val ROUTE_SPLASH = "splash"
    }

    val navigateToMainScreen: () -> Unit = {
        navController.navigate(route = ROUTE_MAIN) {
            popUpTo(ROUTE_SPLASH) {
                inclusive = true
            }
        }
    }
}