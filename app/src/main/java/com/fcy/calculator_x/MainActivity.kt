package com.fcy.calculator_x

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.fcy.calculator_x.navigation.CalculatorNavigation
import com.fcy.calculator_x.ui.theme.CalculatorXTheme

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorXTheme {
                // A surface container using the 'background' color from the theme
                CalculatorNavigation(navigator = rememberNavController(), viewModel = viewModel)
            }
        }
    }
}
