package com.example.healthapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.healthapp.data.PreferenceHelper

@Composable
fun MainScreen(navController: NavController, preferenceHelper: PreferenceHelper) {
    Scaffold(
        topBar = {
            HomeTopBar(onLogout = {
                // Hapus data di PreferenceHelper saat logout
                preferenceHelper.clearData()
                navController.navigate("login") {
                    // Bersihkan stack navigasi
                    popUpTo("login") { inclusive = true }
                }
            })
        },
        bottomBar = { BottomNav(navController) } // Tambahkan BottomNav di sini
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Welcome to Main Screen!", style = TextStyle(fontSize = 24.sp))
            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { navController.navigate("input_data") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Input Data Kesehatan")
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    // Hapus data saat logout
                    preferenceHelper.clearData()
                    navController.navigate("login") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Logout")
            }
        }
    }
}
