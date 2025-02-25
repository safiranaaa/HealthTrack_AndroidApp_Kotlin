package com.example.healthapp

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.healthapp.data.DatabaseHelper
import com.example.healthapp.data.DatabaseHelper.Companion.COLUMN_ASAM_URAT
import com.example.healthapp.data.DatabaseHelper.Companion.COLUMN_BB
import com.example.healthapp.data.DatabaseHelper.Companion.COLUMN_DIASTOL
import com.example.healthapp.data.DatabaseHelper.Companion.COLUMN_GLUKOSA
import com.example.healthapp.data.DatabaseHelper.Companion.COLUMN_ID
import com.example.healthapp.data.DatabaseHelper.Companion.COLUMN_KOLESTEROL
import com.example.healthapp.data.DatabaseHelper.Companion.COLUMN_NAMA
import com.example.healthapp.data.DatabaseHelper.Companion.COLUMN_SISTOL
import com.example.healthapp.data.DatabaseHelper.Companion.COLUMN_TB
import com.example.healthapp.data.DatabaseHelper.Companion.COLUMN_TENSI

@Composable
fun ProfileScreen(navController: NavController) {
    val context = LocalContext.current
    val databaseHelper = DatabaseHelper(context)
    val healthData = remember { mutableStateOf(listOf<Map<String, String>>()) }

    LaunchedEffect(Unit) {
        healthData.value = databaseHelper.getAllHealthData()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profile", color = Color(0xAA232b20)) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("home") }) { // Navigasi kembali ke Home
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back", tint = Color(0xAA232b20))
                    }
                },
                actions = {
                    IconButton(onClick = {
                        // Logika untuk logout
                        Toast.makeText(context, "Logout", Toast.LENGTH_SHORT).show()
                        // Navigasi ke layar start dan hapus back stack
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
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Text("Data Kesehatan", style = TextStyle(fontSize = 24.sp))
            Spacer(modifier = Modifier.height(16.dp))

            // Menampilkan data kesehatan dalam bentuk kartu
            healthData.value.forEach { data ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp), // Menambahkan padding vertikal antar kartu
                    elevation = 4.dp // Menambahkan bayangan pada kartu
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp) // Padding di dalam kartu
                    ) {
                        Text(text = "Nama: ${data[COLUMN_NAMA]}", style = TextStyle(fontSize = 16.sp))
                        Text(text = "BB: ${data[COLUMN_BB]}", style = TextStyle(fontSize = 16.sp))
                        Text(text = "TB: ${data[COLUMN_TB]}", style = TextStyle(fontSize = 16.sp))
                        Text(text = "Tensi: ${data[COLUMN_TENSI]}", style = TextStyle(fontSize = 16.sp))
                        Text(text = "Sistol: ${data[COLUMN_SISTOL]}", style = TextStyle(fontSize = 16.sp))
                        Text(text = "Diastol: ${data[COLUMN_DIASTOL]}", style = TextStyle(fontSize = 16.sp))
                        Text(text = "Glukosa: ${data[COLUMN_GLUKOSA]}", style = TextStyle(fontSize = 16.sp))
                        Text(text = "Asam Urat: ${data[COLUMN_ASAM_URAT]}", style = TextStyle(fontSize = 16.sp))
                        Text(text = "Kolesterol: ${data[COLUMN_KOLESTEROL]}", style = TextStyle(fontSize = 16.sp))
                    }
                }
            }
        }
    }
}