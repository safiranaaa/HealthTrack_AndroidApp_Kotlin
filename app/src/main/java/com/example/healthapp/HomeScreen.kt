package com.example.healthapp

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.platform.LocalContext

@Composable
fun HomeScreen(navController: NavController) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Home", color = Color(0xAA232b20)) },
                actions = {
                    IconButton(onClick = {
                        // Logika untuk logout
                        Toast.makeText(context, "Logout", Toast.LENGTH_SHORT).show()
                        // Tambahkan logika untuk mengarahkan ke layar login dan hapus back stack
                        navController.navigate("start") {
                            popUpTo("home") { inclusive = true }
                        }
                    }) {
                        Icon(Icons.Default.ExitToApp, contentDescription = "Logout", tint = Color(0xAA232b20))
                    }
                },
                backgroundColor = Color(0xAAafd8a3)
            )
        },
        bottomBar = { BottomNav(navController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = { navController.navigate("input_data") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xAAafd8a3),
                    contentColor = Color(0xAA232b20)
                )) {
                Text("Input Data Kesehatan")
            }
        }
    }
}
