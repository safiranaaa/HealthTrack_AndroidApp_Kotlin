package com.example.healthapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.healthapp.data.PreferenceHelper
import com.example.healthapp.MainScreen
import com.example.healthapp.HealthInputScreen
import com.example.healthapp.StartScreen
import com.example.healthapp.BottomNav
import com.example.healthapp.ProfileScreen
import com.example.healthapp.ui.theme.HealthAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HealthAppTheme {
                val navController = rememberNavController()

                // Inisialisasi PreferenceHelper dengan context dari MainActivity
                val preferenceHelper = PreferenceHelper(this)

                NavHost(navController = navController, startDestination = "start") {
                    composable("start") { StartScreen(navController) }
                    composable("new_member") { PinInputScreen(navController, isNewMember = true) }
                    composable("existing_member") { PinInputScreen(navController, isNewMember = false) }
                    composable("home") { HomeScreen(navController) }
                    composable("input_data") { HealthInputScreen(navController) }
                    composable("profile") { ProfileScreen(navController) }
                }
            }
        }
    }
}
